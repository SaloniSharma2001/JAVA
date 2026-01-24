# JAVA

<h1>Exception Handling in Java</h1>

<hr/>

<h2>📌 Agenda</h2>
<ul>
  <li>Introduction</li>
  <li>Runtime Stack Mechanism</li>
  <li>Default Exception Handling in Java</li>
  <li>Exception Hierarchy</li>
  <li>Customized Exception Handling using try-catch</li>
  <li>Control Flow in try-catch</li>
  <li>Methods to Print Exception Information</li>
  <li>Try with Multiple Catch Blocks</li>
  <li>finally Block</li>
  <li>Difference between final, finally, finalize</li>
  <li>Control Flow in try-catch-finally</li>
  <li>Control Flow in Nested try-catch-finally</li>
  <li>Various Combinations of try-catch-finally</li>
  <li>throw and throws Keyword</li>
  <li>Exception Handling Keywords Summary</li>
  <li>Compile-time Errors in Exception Handling</li>
  <li>Customized / User Defined Exceptions</li>
  <li>Top 19 Common Exceptions</li>
  <li>Version Enhancements
    <ul>
      <li>Try-with-resources</li>
      <li>Multi-catch block</li>
    </ul>
  </li>
</ul>

<hr/>

<h2>What is an Exception?</h2>
<p>
An <strong>exception</strong> is an <em>unexpected and unwanted event</em> that disrupts the normal flow of a program during execution.
</p>

<p>
It is <strong>highly recommended</strong> to handle exceptions to ensure smooth and controlled execution of the program.
</p>

<h3>📌 Why do we need Exception Handling?</h3>

<p>
Consider a scenario where:
</p>

<ul>
  <li>A database connection is opened</li>
  <li>Data is being read from the database</li>
  <li>An exception occurs before closing the connection</li>
</ul>

<p>
If the exception is <strong>not handled</strong>, the program terminates abruptly and the database connection remains open.
This leads to <strong>resource leakage</strong>.
</p>

<p>
By handling exceptions properly, we ensure:
</p>

<ul>
  <li>Resources are closed properly</li>
  <li>Program terminates gracefully</li>
  <li>No system resources are wasted</li>
</ul>

<p>
<strong>Graceful termination</strong> of a program is the main goal of exception handling.
</p>

<hr/>

<h2>What is the Meaning of Exception Handling?</h2>
<p>Exception handling means <strong>defining an alternative way</strong> to keep the program running normally even when an exception occurs.</p>
<p>Exception handling is <strong>not meant for repairing bugs</strong> in the program.</p>

<p>
It is used to:
</p>

<ul>
  <li>Handle runtime problems</li>
  <li>Maintain normal program flow</li>
  <li>Prevent abrupt termination</li>
</ul>

<hr/>

<h2>Runtime Stack Mechanism</h2>

<p>
Let us understand how method calls are managed internally by JVM using the <strong>Runtime Stack</strong>.
</p>

<h3>Example Code</h3>

<pre>
class Test {
    public static void main(String[] args) {
        doStuff();
    }

    public static void doStuff() {
        doMoreStuff();
    }

    public static void doMoreStuff() {
        System.out.println("Do more stuff");
    }
}
</pre>

<h3>Thread and Runtime Stack</h3>

<p>
In this program:
</p>

<ul>
  <li>There is only <strong>one thread</strong> → the <code>main</code> thread</li>
  <li>For every thread, JVM creates a <strong>Runtime Stack</strong></li>
</ul>

<p>
Every method call made by a thread is stored in the runtime stack.
</p>

<h3>Runtime Stack Representation</h3>

<pre>
Runtime Stack:
[
  main()
    ↓
  doStuff()
    ↓
  doMoreStuff()
]
</pre>

<h3>Stack Frame / Activation Record</h3>

<p>
Each entry in the runtime stack is called:
</p>

<ul>
  <li><strong>Stack Frame</strong> or</li>
  <li><strong>Activation Record</strong></li>
</ul>

<p>
A stack frame contains:
</p>

<ul>
  <li>Local variables</li>
  <li>Method parameters</li>
  <li>Return address</li>
</ul>

<h3>Stack Cleanup</h3>

<p>
Once <code>doMoreStuff()</code> completes normally:
</p>

<ul>
  <li>Its stack frame is removed</li>
  <li>Then <code>doStuff()</code> is removed</li>
  <li>Finally <code>main()</code> is removed</li>
</ul>

<p>
Before terminating the program, JVM destroys the entire runtime stack.
</p>

<hr/>

<h2>Default Exception Handling in Java</h2>

<h3>Example Code</h3>

<pre>
class Test {
    public static void main(String[] args) {
        doStuff();
    }

    public static void doStuff() {
        doMoreStuff();
    }

    public static void doMoreStuff() {
        System.out.println(10/0);
    }
}
</pre>

<p>
In the above program in doMoreStuff, Arithmetic Exception will occur and as soon as this happens:
</p>

<ul>
  <li>
    The method in which the exception occurs is responsible for creating the
    exception object.
  </li>

  <li>
    This exception object contains details such as the exception name,
    description (message), and the exact location in the code where the
    exception occurred, along with the stack trace information.
  </li>

  <li>
    The exception object is then forwarded to the JVM.
  </li>

  <li>
    The JVM checks whether the current method has an appropriate exception
    handling code (try-catch block).
  </li>

  <li>
    If the exception is not handled in the current method, the JVM removes that
    method from the runtime stack and propagates the exception to the immediate
    calling method.
  </li>

  <li>
    This process continues up the call stack until a matching exception handler
    is found.
  </li>

  <li>
    If none of the methods—including the <code>main()</code> method—handle the
    exception, the JVM invokes its <strong>Default Exception Handler</strong>.
  </li>

  <li>
    The Default Exception Handler prints the complete stack trace and exception
    details to the console and then terminates the program abnormally.
  </li>
</ul>

<p>
If an exception occurs and it is <strong>not handled explicitly</strong> by the programmer, JVM takes care of it using
<strong>Default Exception Handling</strong>.
</p>

<p>
In default exception handling:
</p>

<ul>
  <li>JVM identifies the exception</li>
  <li>Prints exception details</li>
  <li>Terminates the program abnormally</li>
</ul>

<p>
This is why relying only on default exception handling is <strong>not recommended</strong>.
</p>

<hr/>

<h3>Throwable is root for all errors and exceptions.</h3>
<p>Throwable looks like an interface name, but it is a class whose parent class is an object class.</p>
<p>Throwable has two child classes Exception and Error</p>
<p>Exceptions are recoverable using try-catch.</p>
<p>Exceptions are caused by our faulty programs only.</p>
<p>Errors are nonrecoverable. Errors are caused by lack of our system resources. For instance, OutOfMemoryError</p>
<ul>
  <li>Exceptions disrupt normal program flow</li>
  <li>Exception handling ensures graceful termination</li>
  <li>Runtime Stack manages method calls</li>
  <li>Unhandled exceptions are handled by JVM using default mechanism</li>
</ul>

<hr/>
This contains Fundamental JAVA programs.
ABOUT JVM
https://medium.com/@amitvsolutions/jvm-part-6-garbage-collection-a24f6ef5b3ba

https://www.scientecheasy.com/2020/06/instance-block-in-java.html/



