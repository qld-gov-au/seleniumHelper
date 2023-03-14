##Selenium Helper##
[![CircleCI](https://circleci.com/gh/qld-gov-au/seleniumHelper.svg?style=svg)](https://circleci.com/gh/qld-gov-au/seleniumHelper)

This library will load the correct Driver for your browser you choose and ensure that no browser is left behind when it closes

###Main Entry point###
SeleniumHelper.getWebDriverHolder()

Environment Args that you can use:
* headless.disabled
  if set, then headless mode for browsers is turned off

* doScreenPrints
  if set, then screenshots will be taken if performScreenPrint is called
  is used with ```performScreenPrint(WebDriverHolder webDriverHolder, String testName)```

* http.proxyHost, https.proxyHost
  These variables are passed through to the browser it seems


###Change log###

* Allow hand off without deleting cookies
* Allow browser reuse to be changed from default 10 to your preferred usage.
* Allow download directory to be set on browser creation
