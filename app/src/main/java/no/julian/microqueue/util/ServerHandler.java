package no.julian.microqueue.util;

import java.net.HttpURLConnection;
import java.net.URL;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerHandler {

	private static final String baseUrl = "http://10.22.183.80:8080/MicroQueueServer/api/";

	private static String token;

	private static Retrofit retrofit;
	
	private static QueueService service;

	private static ServerHandler handler;

	public static  ServerHandler getHandler(){
		if (handler != null) {
			return handler;
		} else {
			handler = new ServerHandler();
			return handler;
		}
	}
	
	public static void EnsureHandler(){
		if (handler == null) {
			handler = new ServerHandler();
		}
	}

	private ServerHandler(){
		retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
		service = retrofit.create(QueueService.class);
	}
	
	public static void login(LoginCredentials credentials){
		EnsureHandler();
		SingleObserver<LoginResult> result = service.login(credentials)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeWith(new SingleObserver<LoginResult>() {
					CompositeDisposable compositeDisposable = new CompositeDisposable();
					
					@Override
					public void onSubscribe(Disposable d) {
						compositeDisposable.add(d);
					}
	
					@Override
					public void onSuccess(LoginResult loginResult) {
						// Update the UI
						setToken(loginResult.getToken());
						compositeDisposable.dispose();
					}
	
					@Override
					public void onError(Throwable e) {
						// Try again or something
					}
				});
	}

	@Deprecated
	public static String getResource(final String endpoint) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try  {
					URL buyUrl = new URL(baseUrl + endpoint);
					HttpURLConnection httpCon = (HttpURLConnection) buyUrl.openConnection();
					//httpCon.setDoOutput(true);
					httpCon.setRequestProperty("Authorization", token) ;
					httpCon.setRequestProperty("Content-Type", "application/json");
					httpCon.setDoOutput(true);
					httpCon.setRequestMethod("POST");
					httpCon.connect();
					httpCon.getInputStream();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		return "the result";
	}

	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		ServerHandler.token = token;
	}
}
