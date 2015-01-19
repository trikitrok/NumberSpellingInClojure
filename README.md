# number-spelling

Spell out a number. For example:

<pre>
      99 --> ninety nine
     300 --> three hundred
     310 --> three hundred and ten
    1501 --> one thousand, five hundred and one
   12608 --> twelve thousand, six hundred and nine
  512607 --> five hundred and twelve thousand, six hundred and seven
43112607 --> forty three million, one hundred and twelve thousand,six hundred and three   
</pre>

The project uses [Midje](https://github.com/marick/Midje/).

## How to run the tests

`lein midje` will run all tests.

`lein midje namespace.*` will run only tests beginning with "namespace.".

`lein midje :autotest` will run all the tests indefinitely. It sets up a
watcher on the code files. If they change, only the relevant tests will be
run again.
