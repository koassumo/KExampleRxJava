package com.example.kexamplerxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainPresenter() {

    var viewState: IMainView? = null

    fun attach(view: IMainView){
        this.viewState = view
        //initObserverStandardDisplay1()
    }

    fun exec (){
        viewState?.let { Consumer(Producer(), it).exec() }
    }

    class Producer {
        fun createJustObserverble(): Observable<String> {
            return Observable.just("1", "2", "3")
        }
    }

    class Consumer (val producer: Producer, var viewState: IMainView) {
        val stringObserverDisplay1 = object : Observer<String> {

            var disposable: Disposable? = null

            override fun onSubscribe(d: Disposable?) {
                disposable = d
                viewState.screenResult1("onSub ")
            }

            override fun onNext(t: String?) {
                if (t != null) {
                    viewState.screenResult1(t)
                }
            }

            override fun onError(e: Throwable?) {
                println("onError: ${e?.message}")
            }

            override fun onComplete() {
                viewState.screenResult1("onComp")
            }

        }

        fun execJust () {
            producer.createJustObserverble().subscribe(stringObserverDisplay1)
        }

        fun exec () {
            execJust ()
        }
    }



//
//    fun initObserverStandardDisplay1() {
//        val observerStandardDisplay1 = object : Observer<String> {
//            var disposable: Disposable? = null
//
//            override fun onSubscribe(d: Disposable?) {
//                disposable = d
//                viewState?.screenResult1()
//            }
//
//            override fun onNext(s: String?) {
//                viewState?.screenResult1()
//            }
//
//            override fun onError(e: Throwable?) {
//                println("onError: ${e?.message}")
//            }
//
//            override fun onComplete() {
//                viewState?.screenResult1()
//            }
//        }
//    }
//
//    fun mClickObservableJust () {
//
//
//    }


}
//
//            @Override
//            public void onNext(String s) {
//                textViewDisplay1.setText(textViewDisplay1.getText().toString() + s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//            }
//
//            @Override
//            public void onComplete() {
//                textViewDisplay1.setText(textViewDisplay1.getText().toString() + "\n");
//            }
//        };
//    }
//
//
//
//    fun mClickObservableJust () {
//        viewState?.screenResult1()
//        viewState?.screenResult2()
//    }
//
//}