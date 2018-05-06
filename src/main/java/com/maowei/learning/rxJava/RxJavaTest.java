package com.maowei.learning.rxJava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

public class RxJavaTest {
    public static void main(String[] args) {
        /*Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("====Hello World!====");
                subscriber.onNext("Hello World!");
                subscriber.onCompleted();
            }
        });*/

        Observable<String> myObservable = Observable.defer(new Func0<Observable<String>>() {
            public Observable<String> call() {
                return Observable.just("Hello","World!");
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

        Action1<String> onNextAction = new Action1<String>() {
            public void call(String s) {
                System.out.println(s);
            }
        };

        //myObservable.subscribe(mySubscriber);
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World!");
        //Observable.just("Hello","World!").subscribe(mySubscriber);
        //Observable.from(list).subscribe(onNextAction);

        Observable.just("1+2").map(new Func1<String, Integer>() {
            public Integer call(String str){
                String[] strs = str.split("\\+");
                return Integer.valueOf(strs[0])+Integer.valueOf(strs[1]);
            }
        }).subscribe(new Action1<Integer>() {
            public void call(Integer integer) {
                System.out.print(integer);
            }
        });
    }
}
