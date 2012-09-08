cucumber-automate
======

Barebone project to try out cucumber

Initial setup:
* Remove existing software
<pre>
cd ${HOME}/.m2/repository
rm -rf cuke4duke .jruby org/picocontainer
</pre>

* Let maven do its magic. Run this in the project root

<pre>
mvn -Dcucumber.installGems=true cuke4duke:cucumber
</pre>
