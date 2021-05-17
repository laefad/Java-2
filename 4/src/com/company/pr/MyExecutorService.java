package com.company.pr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

// https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html
public class MyExecutorService implements ExecutorService {

    private int amount;
    private List<Future> futures;
    private boolean shutdown = false;

    MyExecutorService(int amount){
        this.amount = amount;
        this.futures = new ArrayList<>(amount);

        // Создаем потоки, заполняя их пустыми работами,
        // сразу завершая их
        for (int i = 0; i < amount; i++){
            futures.add(new FutureTask(() -> null));
            futures.get(i).cancel(true);
        }
    }

    @Override
    public void shutdown() {
        // Завершаем все задачи
        futures.forEach(f -> f.cancel(false));
        shutdown = true;
    }

    @Override
    public List<Runnable> shutdownNow() {
        // Собираем все незавершенные задачи и возвращаем их
        // Завершаем все задачи
        List<Runnable> tasks = futures.stream()
                .filter(f -> !f.isCancelled() && !f.isDone())
                .map(f -> (Runnable) f)
                .collect(Collectors.toList());
        shutdown();
        return tasks;
    }

    @Override
    public boolean isShutdown() {
        return shutdown;
    }

    @Override
    public boolean isTerminated() {
        return shutdown;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        // Если нет текущих задач, то возвращаем true
        // Иначе ждем указанное время и вновь проверяем
        // Если задачи остались, то возвращаем false
        boolean all_completed = true;

        for (Future f : futures) {
            if (!f.isDone() && !f.isCancelled()) {
                all_completed = false;
                break;
            }
        }

        if (!all_completed)
            unit.sleep(timeout);

        all_completed = true;
        for (Future f : futures) {
            if (!f.isDone() && !f.isCancelled()) {
                all_completed = false;
                break;
            }
        }

        return all_completed;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        // Добавляем задачу и возвращаем ее Future,
        // если задача добавилась
        if (task == null)
            throw new NullPointerException();

        for (int i = 0; i < amount; i++) {
            if (futures.get(i).isDone() || futures.get(i).isCancelled()) {
                RunnableFuture<T> rf = new FutureTask<>(task);
                futures.set(i, rf);
                execute(rf);
                return rf;
            }
        }

        throw new NullPointerException();
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        // Добавляем задачу и возвращаем ее Future,
        // если задача добавилась
        // К задаче добавляем возвращаемое значение
        if (task == null)
            throw new NullPointerException();

        for (int i = 0; i < amount; i++) {
            if (futures.get(i).isDone() || futures.get(i).isCancelled()) {
                RunnableFuture<T> rf = new FutureTask<>(task, result);
                futures.set(i, rf);
                execute(rf);
                return rf;
            }
        }

        throw new NullPointerException();
    }

    @Override
    public Future<?> submit(Runnable task) {
        // Добавляем задачу и возвращаем ее Future,
        // если задача добавилась
        // Задача ничего не возвращает (null)

        if (task == null)
            throw new NullPointerException();

        for (int i = 0; i < amount; i++) {
            if (futures.get(i).isDone() || futures.get(i).isCancelled()) {
                RunnableFuture<Void> rf = new FutureTask<>(task, null);
                futures.set(i, rf);
                execute(rf);
                return rf;
            }
        }

        throw new NullPointerException();
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        // Распределяем задачи по Future,
        // Собираем Future в список и возвращаем его
        return tasks.stream()
                .map(this::submit)
                .collect(Collectors.toList());
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        // Распределяем задачи по Future,
        // Ждем определенное время
        // Собираем Future в список и возвращаем его
        List<Future<T>> result = tasks.stream()
                .map(this::submit)
                .collect(Collectors.toList());
        awaitTermination(timeout, unit);
        return result;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) {
        // Распределяем задачи по Future,
        // возвращаем любую выполненную задачу
        return invokeAll(tasks).stream()
                    .map(f -> {
                        T res = null;
                        try {
                            res = f.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                        return res;
                    })
                .findFirst()
                .get();
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException{
        // Распределяем задачи по Future,
        // возвращаем любую выполненную задачу
        // после определенного времени
        List<Future<T>> futureTasks = invokeAll(tasks);
        awaitTermination(timeout, unit);
        return futureTasks.stream()
                .map(f -> {
                    T res = null;
                    try {
                        res = f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    return res;
                })
                .findFirst()
                .get();
    }

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
