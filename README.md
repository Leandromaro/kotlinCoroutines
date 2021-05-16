# Kotlin Coroutines

## What is a Coroutine?

Is a design patter that can be used to run async code.

## How it works?

Coroutines are said to be a "lighter version" of threads, but Coroutines they are a completely separate thing from any scheduling policy.

They do not directly map to native os threads, because of that they are very faster to create and destroy compared to threads. There is no additional overhead of switching context between threads. Practically you can have thousands of or even tens of thousands of coroutines. There might be only one thread having thousands of coroutines.

A coroutine is basically a call chain of suspend funs. Suspension is totally under your control: you just have to call suspendCoroutine. You'll get a callback object so you can call its resume method and get back to where you suspended.

The two most important building blocks to create/start/run new coroutines are __coroutine scope__ and __coroutine builders__.

__Coroutine scope__ consists of all the machinery required to run coroutine, for example, it knows where (on which thread) to run coroutine and coroutine builders are used to create a new coroutine.
If I have to give an analogy with threads, coroutine scope can be seen as Java’s ExecutorService and __coroutine builders__ are factories to create Runnable instances.


## Coroutine Scope Builders
CoroutineScope is an interface that has a single abstract property called coroutineContext.


```
public interface CoroutineScope {
    public val coroutineContext: CoroutineContext
}
```

CoroutineScope is nothing but a CoroutineContext, the only difference is in their intended use. Roman Elizarov explains this in detail in [following blog post](https://medium.com/@elizarov/coroutine-context-and-scope-c8b255d59055)

Every coroutine created using this scope becomes the child of this job. This is how a parent-child relationship gets created between coroutines. _If any of the coroutines throws an unhandled exception, it’s parent job gets canceled which ultimately cancels all its children_. This is called __structured concurrency__.
