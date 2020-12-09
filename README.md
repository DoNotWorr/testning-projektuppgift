# testning-projektuppgift
Alexander Wiklunds projektuppgift i kursen Testning, HT-2020

Uses this kata:
https://kata-log.rocks/string-calculator-kata

Step 1-7 has their own branches
Step 8 and 9 is a combined branch
One additional branch to create CustomDelimiter class.

As of 2020-12-09:
* In hindsight, StringCalculator.add() is too spread out and long.

* CustomDelimiter code works nicely for the most part,
but at the moment it only converts delimiters to a format which tries to deal with regex special characters.

* To justify CustomDelimiter being it's own class, it would've probably been better to let the class handle the input
and let StringCalculater deal mostly with rules (no negative numbers, no numbers bigger than 1000 etc).
