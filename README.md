# TestDoubles
Test doubles are like stunt doubles, they take the place of the 'real'  thing in test code.
## Dummy Object
This is a placeholder object that is passed to the SUT as an argument (or an attribute of an argument) but is never actually used.

* We can create a dummy  [manually](https://www.testright.nl/2016/12/02/test-doubles-creating-a-dummy-object-manually/)
* We can create a dummy [with a mocking framework](http://www.testright.nl/2016/12/16/test-doubles-creating-a-dummy-object-using-a-mocking-framework/)

## Test Stub
This is an object that replaces a real component on which the SUT depends so that the test can control the indirect inputs of the SUT. It allows the test to force the SUT down paths it might not otherwise exercise.
Some examples are [nard-coded and configurable responders and saboteurs](https://www.testright.nl/2017/01/16/test-doubles-creating-a-stub/)
