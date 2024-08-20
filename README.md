# EASEY - Test Automation
[![GitHub](https://img.shields.io/github/license/US-EPA-CAMD/easey-testing)](https://github.com/US-EPA-CAMD/easey-testing/blob/master/LICENSE)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=US-EPA-CAMD_easey-testing&metric=alert_status)](https://sonarcloud.io/dashboard?id=US-EPA-CAMD_easey-testing)
[![CI/CD](https://github.com/US-EPA-CAMD/easey-testing/workflows/CI/badge.svg)](https://github.com/US-EPA-CAMD/easey-testing/actions)<br>
Automated test scripts for EASEY applications

## ARCHIVED
This repository has been archived as of August 20, 2024

## Dependencies 
These languages, programs, and applications are necessary for the installation and use of the EASEY-testing REPO 
1. Java 11
2. Maven
3. ChromeDriver (Placed in directory, see below)
4. IntelliJ (IDE, good starting port) 

Maven 3.8.5 - Ensure Chrome and ChromeDriver are the same version by using the latest release for both.

## Getting Started 

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes 

  1. Make sure maven gets added to the PATH system environment variable
      - Note: This doesn't always happen during installation, check if ` mvn -version ` will run in command line
  2. install the chromedriver to a folder named `driver` in the home directory
      - I.e. for Windows ``` C:/Users/%USERNAME%/driver/chromedriver.exe) ```
  3. Run ``` mvn install ``` to install the dependency packages

## Congifuration Settings

- -Dname (required) - This is the name of tests to run. 
      - It does not have to be the whole name, but can be a partial string, and will match to all of the tests that contains the provided name.
      - Multiple names can be included by separating the values with a comma 
      - Start the value with a ``` ! ``` or ```  ~ ``` to exclude tests with that value 
- -Dmode
  - Default: ```single```
  - Alternate Option: ```multiple```
    - Runs tests specified in multiple.xml 
- -Drunmode (optional) 
    - Default: ``` local ```
    - Alternative Option: ``` browserStack ```, which will run headless (aka no gui)

- -Ddebug (optional)
    - Default: ``` false```
    - Alternative option: ``` true```
    - Turn on debug methods, i.e ``` pause ``` & ``` debugPrint ```
 
- -Denv (optional)
  - Default: ```env```
  - Alternate Option: ```beta```
  
- -Dbrowser (optional)
  - Default: ```chrome```

## Testing 

```

mvn test -Dname=*

```

## Updating Chromedriver
- When? Chrome will update automatically in most cases. You will experience an error message similar to <i> "SessionNotCreatedException: Message: session not created: This version of ChromeDriver only supports Chrome version #.#" </i>
- How?
  1. Check chrome version: three dots in the top right of chrome, help, about
  2. Download a chromedriver that matches your new chrome version
  3. Unzip the file in your Downloads folder
  4. Copy the content and paste here, replacing the old version: ``` C:/Users/%USERNAME%/driver/) ```
- Remember to restart your IDE
## License & Contributing

​
This project is licensed under the MIT License. We encourage you to read this project’s [License](https://github.com/US-EPA-CAMD/devops/blob/master/LICENSE), [Contributing Guidelines](https://github.com/US-EPA-CAMD/devops/blob/master/CONTRIBUTING.md), and [Code of Conduct](https://github.com/US-EPA-CAMD/devops/blob/master/CODE_OF_CONDUCT.md).

## Disclaimer
The United States Environmental Protection Agency (EPA) GitHub project code is provided on an "as is" basis and the user assumes responsibility for its use. EPA has relinquished control of the information and no longer has responsibility to protect the integrity , confidentiality, or availability of the information. Any reference to specific commercial products, processes, or services by service mark, trademark, manufacturer, or otherwise, does not constitute or imply their endorsement, recommendation or favoring by EPA. The EPA seal and logo shall not be used in any manner to imply endorsement of any commercial product or activity by EPA or the United States Government.


