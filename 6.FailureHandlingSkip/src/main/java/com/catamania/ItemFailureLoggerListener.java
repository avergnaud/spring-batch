package com.catamania;

import org.springframework.batch.core.listener.ItemListenerSupport;

public class ItemFailureLoggerListener extends ItemListenerSupport {

	public void onReadError(Exception ex) {
		System.out.println("ERR");
	}

	public void onWriteError(Exception ex, Object item) {
		System.out.println("ERR");
	}

}
