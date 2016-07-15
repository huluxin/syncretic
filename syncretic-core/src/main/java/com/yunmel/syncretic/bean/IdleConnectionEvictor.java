/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.bean;

import org.apache.http.conn.HttpClientConnectionManager;

public class IdleConnectionEvictor extends Thread {
  private final HttpClientConnectionManager connMgr;
  private volatile boolean shutdown;

  public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
    this.connMgr = connMgr;
    start();
  }

  public void run() {
    try {
      while (!this.shutdown)
        synchronized (this) {
          wait(30000L);
          this.connMgr.closeExpiredConnections();
        }
    } catch (InterruptedException localInterruptedException) {
    }
  }

  public void shutdown() {
    this.shutdown = true;
    synchronized (this) {
      notifyAll();
    }
  }
}
