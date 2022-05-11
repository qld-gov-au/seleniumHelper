## Selenium Helper

[![Java CI](https://github.com/qld-gov-au/seleniumHelper/actions/workflows/test.yml/badge.svg)](https://github.com/qld-gov-au/seleniumHelper/actions/workflows/test.yml)

This library will load the correct Driver for your browser you choose and ensure that no browser is left behind when it closes

### Main Entry point
SeleniumHelper.getWebDriverHolder()

Environment Args that you can use:
* headless.disabled
  if set, then headless mode for browsers is turned off

* doScreenPrints
  if set, then screenshots will be taken if performScreenPrint is called
  is used with ```performScreenPrint(WebDriverHolder webDriverHolder, String testName)```

* http.proxyHost, https.proxyHost
  These variables are passed through to the browser it seems


### Change log

Allow hand off without deleting cookies
Allow browser reuse to be changed from default 10 to your preferred usage.

Updated to selenium 4.x, support newer versions of java.
