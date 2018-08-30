package com.kotlin.test.central.gateway.http;

public enum BaseUrl {
  SOME_STUFF("/SomeStuff");


  private final String path;

  BaseUrl(final String s) {
    this.path = s;
  }

  public String getPath() {
    return path;
  }
}
