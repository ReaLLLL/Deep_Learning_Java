package com.maowei.learning.rxJava;

import rx.Observable;
import rx.Subscriber;

public class RxJavaTest {
    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("====Hello World!====");
                subscriber.onNext("Hello World!");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            public void onCompleted() {

            }

            public void onError(Throwable throwable) {

            }

            public void onNext(String s) {
                System.out.println(s);
            }
        };

        myObservable.subscribe(mySubscriber);
        Observable.just("Hello World!");
    }
}
