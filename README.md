## Selenium Helper

[![Java CI](https://github.com/qld-gov-au/seleniumHelper/actions/workflows/test.yml/badge.svg)](https://github.com/qld-gov-au/seleniumHelper/actions/workflows/test.yml)

This library will load the correct Driver for your browser you choose and ensure that no browser is left behind when it closes

### Main Entry point
`SeleniumHelper.getWebDriverHolder()`

Environment Args that you can use:
* `headless.disabled`

  If set, then headless mode for browsers is turned off (that is, the browser windows will open).

* `doScreenPrints`

  If set, then screenshots will be taken if `performScreenPrint` is called. Is used with
  ```performScreenPrint(WebDriverHolder webDriverHolder, String testName)```.

* `http.proxyHost` and `https.proxyHost`

  These variables are passed through to the browser.

### Missing Firefox Profile

Using the Firefox web driver may cause an error saying the profile could not be found. This will cause the driver to
hang if running headless or throw an error on acknowledgement. This issue arose when using Firefox installed with Snap
on an Ubuntu 22.04 machine. The resolution (as per [this guide](https://www.omgubuntu.co.uk/2022/04/how-to-install-firefox-deb-apt-ubuntu-22-04))
is as follows:

1. Uninstall the Firefox Snap.
   
   ```shell
   sudo snap remove firefox
   ```

2. Create an APT keyring if one has not already been created.

   ```shell
   sudo install -d -m 0755 /etc/apt/keyrings
   ```

3. Import the Mozilla APT repo signing key.

   ```shell
   wget -q https://packages.mozilla.org/apt/repo-signing-key.gpg -O- | sudo tee /etc/apt/keyrings/packages.mozilla.org.asc > /dev/null
   ```

4. Add Mozilla signing key to `sources.list`.

   ```shell
   echo "deb [signed-by=/etc/apt/keyrings/packages.mozilla.org.asc] https://packages.mozilla.org/apt mozilla main" | sudo tee -a /etc/apt/sources.list.d/mozilla.list > /dev/null
   ```

5. Set the Firefox package priority to ensure Mozilla's DEB version is always preferred. Not performing this step may
   lead to APT reinstalling the Firefox Snap.

   ```shell
   echo '
   Package: *
   Pin: origin packages.mozilla.org
   Pin-Priority: 1000
   ' | sudo tee /etc/apt/preferences.d/mozilla
   ```

6. Install the Firefox DEB.

   ```shell
   sudo apt update && sudo apt install firefox
   ```

7. (Optional) Install a localised version of Firefox. The example below is for French.

   ```shell
   sudo apt install firefox-l10n-fr
   ```
   
   A list of all available languages can be found using `apt-cache search firefox-l10n`.

### Change log

* Allow hand off without deleting cookies
* Allow browser reuse to be changed from default 10 to your preferred usage.
* Allow download directory to be set on browser creation
