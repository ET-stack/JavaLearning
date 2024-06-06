<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- NewPage -->
<html lang="en">
<head>
<!-- Generated by javadoc (1.8.0_275) on Wed Mar 17 09:46:11 UTC 2021 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WorkerService (Apache ZooKeeper - Server 3.7.0 API)</title>
<meta name="date" content="2021-03-17">
<link rel="stylesheet" type="text/css" href="../../../../stylesheet.css" title="Style">
<script type="text/javascript" src="../../../../script.js"></script>
</head>
<body>
<script type="text/javascript"><!--
    try {
        if (location.href.indexOf('is-external=true') == -1) {
            parent.document.title="WorkerService (Apache ZooKeeper - Server 3.7.0 API)";
        }
    }
    catch(err) {
    }
//-->
var methods = {"i0":10,"i1":10,"i2":10,"i3":10,"i4":10};
var tabs = {65535:["t0","All Methods"],2:["t2","Instance Methods"],8:["t4","Concrete Methods"]};
var altColor = "altColor";
var rowColor = "rowColor";
var tableTab = "tableTab";
var activeTableTab = "activeTableTab";
</script>
<noscript>
<div>JavaScript is disabled on your browser.</div>
</noscript>
<!-- ========= START OF TOP NAVBAR ======= -->
<div class="topNav"><a name="navbar.top">
<!--   -->
</a>
<div class="skipNav"><a href="#skip.navbar.top" title="Skip navigation links">Skip navigation links</a></div>
<a name="navbar.top.firstrow">
<!--   -->
</a>
<ul class="navList" title="Navigation">
<li><a href="../../../../overview-summary.html">Overview</a></li>
<li><a href="package-summary.html">Package</a></li>
<li class="navBarCell1Rev">Class</li>
<li><a href="class-use/WorkerService.html">Use</a></li>
<li><a href="package-tree.html">Tree</a></li>
<li><a href="../../../../deprecated-list.html">Deprecated</a></li>
<li><a href="../../../../index-all.html">Index</a></li>
<li><a href="../../../../help-doc.html">Help</a></li>
</ul>
</div>
<div class="subNav">
<ul class="navList">
<li><a href="../../../../org/apache/zookeeper/server/UnimplementedRequestProcessor.html" title="class in org.apache.zookeeper.server"><span class="typeNameLink">Prev&nbsp;Class</span></a></li>
<li><a href="../../../../org/apache/zookeeper/server/WorkerService.WorkRequest.html" title="class in org.apache.zookeeper.server"><span class="typeNameLink">Next&nbsp;Class</span></a></li>
</ul>
<ul class="navList">
<li><a href="../../../../index.html?org/apache/zookeeper/server/WorkerService.html" target="_top">Frames</a></li>
<li><a href="WorkerService.html" target="_top">No&nbsp;Frames</a></li>
</ul>
<ul class="navList" id="allclasses_navbar_top">
<li><a href="../../../../allclasses-noframe.html">All&nbsp;Classes</a></li>
</ul>
<div>
<script type="text/javascript"><!--
  allClassesLink = document.getElementById("allclasses_navbar_top");
  if(window==top) {
    allClassesLink.style.display = "block";
  }
  else {
    allClassesLink.style.display = "none";
  }
  //-->
</script>
</div>
<div>
<ul class="subNavList">
<li>Summary:&nbsp;</li>
<li><a href="#nested.class.summary">Nested</a>&nbsp;|&nbsp;</li>
<li>Field&nbsp;|&nbsp;</li>
<li><a href="#constructor.summary">Constr</a>&nbsp;|&nbsp;</li>
<li><a href="#method.summary">Method</a></li>
</ul>
<ul class="subNavList">
<li>Detail:&nbsp;</li>
<li>Field&nbsp;|&nbsp;</li>
<li><a href="#constructor.detail">Constr</a>&nbsp;|&nbsp;</li>
<li><a href="#method.detail">Method</a></li>
</ul>
</div>
<a name="skip.navbar.top">
<!--   -->
</a></div>
<!-- ========= END OF TOP NAVBAR ========= -->
<!-- ======== START OF CLASS DATA ======== -->
<div class="header">
<div class="subTitle">org.apache.zookeeper.server</div>
<h2 title="Class WorkerService" class="title">Class WorkerService</h2>
</div>
<div class="contentContainer">
<ul class="inheritance">
<li><a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true" title="class or interface in java.lang">java.lang.Object</a></li>
<li>
<ul class="inheritance">
<li>org.apache.zookeeper.server.WorkerService</li>
</ul>
</li>
</ul>
<div class="description">
<ul class="blockList">
<li class="blockList">
<hr>
<br>
<pre>public class <span class="typeNameLabel">WorkerService</span>
extends <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true" title="class or interface in java.lang">Object</a></pre>
<div class="block">WorkerService is a worker thread pool for running tasks and is implemented
 using one or more ExecutorServices. A WorkerService can support assignable
 threads, which it does by creating N separate single thread ExecutorServices,
 or non-assignable threads, which it does by creating a single N-thread
 ExecutorService.
   - NIOServerCnxnFactory uses a non-assignable WorkerService because the
     socket IO requests are order independent and allowing the
     ExecutorService to handle thread assignment gives optimal performance.
   - CommitProcessor uses an assignable WorkerService because requests for
     a given session must be processed in order.
 ExecutorService provides queue management and thread restarting, so it's
 useful even with a single thread.</div>
</li>
</ul>
</div>
<div class="summary">
<ul class="blockList">
<li class="blockList">
<!-- ======== NESTED CLASS SUMMARY ======== -->
<ul class="blockList">
<li class="blockList"><a name="nested.class.summary">
<!--   -->
</a>
<h3>Nested Class Summary</h3>
<table class="memberSummary" border="0" cellpadding="3" cellspacing="0" summary="Nested Class Summary table, listing nested classes, and an explanation">
<caption><span>Nested Classes</span><span class="tabEnd">&nbsp;</span></caption>
<tr>
<th class="colFirst" scope="col">Modifier and Type</th>
<th class="colLast" scope="col">Class and Description</th>
</tr>
<tr class="altColor">
<td class="colFirst"><code>static class&nbsp;</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../../../../org/apache/zookeeper/server/WorkerService.WorkRequest.html" title="class in org.apache.zookeeper.server">WorkerService.WorkRequest</a></span></code>
<div class="block">Callers should implement a class extending WorkRequest in order to
 schedule work with the service.</div>
</td>
</tr>
</table>
</li>
</ul>
<!-- ======== CONSTRUCTOR SUMMARY ======== -->
<ul class="blockList">
<li class="blockList"><a name="constructor.summary">
<!--   -->
</a>
<h3>Constructor Summary</h3>
<table class="memberSummary" border="0" cellpadding="3" cellspacing="0" summary="Constructor Summary table, listing constructors, and an explanation">
<caption><span>Constructors</span><span class="tabEnd">&nbsp;</span></caption>
<tr>
<th class="colOne" scope="col">Constructor and Description</th>
</tr>
<tr class="altColor">
<td class="colOne"><code><span class="memberNameLink"><a href="../../../../org/apache/zookeeper/server/WorkerService.html#WorkerService-java.lang.String-int-boolean-">WorkerService</a></span>(<a href="https://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true" title="class or interface in java.lang">String</a>&nbsp;name,
             int&nbsp;numThreads,
             boolean&nbsp;useAssignableThreads)</code>&nbsp;</td>
</tr>
</table>
</li>
</ul>
<!-- ========== METHOD SUMMARY =========== -->
<ul class="blockList">
<li class="blockList"><a name="method.summary">
<!--   -->
</a>
<h3>Method Summary</h3>
<table class="memberSummary" border="0" cellpadding="3" cellspacing="0" summary="Method Summary table, listing methods, and an explanation">
<caption><span id="t0" class="activeTableTab"><span>All Methods</span><span class="tabEnd">&nbsp;</span></span><span id="t2" class="tableTab"><span><a href="javascript:show(2);">Instance Methods</a></span><span class="tabEnd">&nbsp;</span></span><span id="t4" class="tableTab"><span><a href="javascript:show(8);">Concrete Methods</a></span><span class="tabEnd">&nbsp;</span></span></caption>
<tr>
<th class="colFirst" scope="col">Modifier and Type</th>
<th class="colLast" scope="col">Method and Description</th>
</tr>
<tr id="i0" class="altColor">
<td class="colFirst"><code>void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../../../../org/apache/zookeeper/server/WorkerService.html#join-long-">join</a></span>(long&nbsp;shutdownTimeoutMS)</code>&nbsp;</td>
</tr>
<tr id="i1" class="rowColor">
<td class="colFirst"><code>void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../../../../org/apache/zookeeper/server/WorkerService.html#schedule-org.apache.zookeeper.server.WorkerService.WorkRequest-">schedule</a></span>(<a href="../../../../org/apache/zookeeper/server/WorkerService.WorkRequest.html" title="class in org.apache.zookeeper.server">WorkerService.WorkRequest</a>&nbsp;workRequest)</code>
<div class="block">Schedule work to be done.</div>
</td>
</tr>
<tr id="i2" class="altColor">
<td class="colFirst"><code>void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../../../../org/apache/zookeeper/server/WorkerService.html#schedule-org.apache.zookeeper.server.WorkerService.WorkRequest-long-">schedule</a></span>(<a href="../../../../org/apache/zookeeper/server/WorkerService.WorkRequest.html" title="class in org.apache.zookeeper.server">WorkerService.WorkRequest</a>&nbsp;workRequest,
        long&nbsp;id)</code>
<div class="block">Schedule work to be done by the thread assigned to this id.</div>
</td>
</tr>
<tr id="i3" class="rowColor">
<td class="colFirst"><code>void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../../../../org/apache/zookeeper/server/WorkerService.html#start--">start</a></span>()</code>&nbsp;</td>
</tr>
<tr id="i4" class="altColor">
<td class="colFirst"><code>void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../../../../org/apache/zookeeper/server/WorkerService.html#stop--">stop</a></span>()</code>&nbsp;</td>
</tr>
</table>
<ul class="blockList">
<li class="blockList"><a name="methods.inherited.from.class.java.lang.Object">
<!--   -->
</a>
<h3>Methods inherited from class&nbsp;java.lang.<a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true" title="class or interface in java.lang">Object</a></h3>
<code><a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#clone--" title="class or interface in java.lang">clone</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#equals-java.lang.Object-" title="class or interface in java.lang">equals</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#finalize--" title="class or interface in java.lang">finalize</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#getClass--" title="class or interface in java.lang">getClass</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#hashCode--" title="class or interface in java.lang">hashCode</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#notify--" title="class or interface in java.lang">notify</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#notifyAll--" title="class or interface in java.lang">notifyAll</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#toString--" title="class or interface in java.lang">toString</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#wait--" title="class or interface in java.lang">wait</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#wait-long-" title="class or interface in java.lang">wait</a>, <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html?is-external=true#wait-long-int-" title="class or interface in java.lang">wait</a></code></li>
</ul>
</li>
</ul>
</li>
</ul>
</div>
<div class="details">
<ul class="blockList">
<li class="blockList">
<!-- ========= CONSTRUCTOR DETAIL ======== -->
<ul class="blockList">
<li class="blockList"><a name="constructor.detail">
<!--   -->
</a>
<h3>Constructor Detail</h3>
<a name="WorkerService-java.lang.String-int-boolean-">
<!--   -->
</a>
<ul class="blockListLast">
<li class="blockList">
<h4>WorkerService</h4>
<pre>public&nbsp;WorkerService(<a href="https://docs.oracle.com/javase/8/docs/api/java/lang/String.html?is-external=true" title="class or interface in java.lang">String</a>&nbsp;name,
                     int&nbsp;numThreads,
                     boolean&nbsp;useAssignableThreads)</pre>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>name</code> - worker threads are named &lt;name&gt;Thread-##</dd>
<dd><code>numThreads</code> - number of worker threads (0 - N)
                              If 0, scheduled work is run immediately by
                              the calling thread.</dd>
<dd><code>useAssignableThreads</code> - whether the worker threads should be
                              individually assignable or not</dd>
</dl>
</li>
</ul>
</li>
</ul>
<!-- ============ METHOD DETAIL ========== -->
<ul class="blockList">
<li class="blockList"><a name="method.detail">
<!--   -->
</a>
<h3>Method Detail</h3>
<a name="schedule-org.apache.zookeeper.server.WorkerService.WorkRequest-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>schedule</h4>
<pre>public&nbsp;void&nbsp;schedule(<a href="../../../../org/apache/zookeeper/server/WorkerService.WorkRequest.html" title="class in org.apache.zookeeper.server">WorkerService.WorkRequest</a>&nbsp;workRequest)</pre>
<div class="block">Schedule work to be done.  If a worker thread pool is not being
 used, work is done directly by this thread. This schedule API is
 for use with non-assignable WorkerServices. For assignable
 WorkerServices, will always run on the first thread.</div>
</li>
</ul>
<a name="schedule-org.apache.zookeeper.server.WorkerService.WorkRequest-long-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>schedule</h4>
<pre>public&nbsp;void&nbsp;schedule(<a href="../../../../org/apache/zookeeper/server/WorkerService.WorkRequest.html" title="class in org.apache.zookeeper.server">WorkerService.WorkRequest</a>&nbsp;workRequest,
                     long&nbsp;id)</pre>
<div class="block">Schedule work to be done by the thread assigned to this id. Thread
 assignment is a single mod operation on the number of threads.  If a
 worker thread pool is not being used, work is done directly by
 this thread.</div>
</li>
</ul>
<a name="start--">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>start</h4>
<pre>public&nbsp;void&nbsp;start()</pre>
</li>
</ul>
<a name="stop--">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>stop</h4>
<pre>public&nbsp;void&nbsp;stop()</pre>
</li>
</ul>
<a name="join-long-">
<!--   -->
</a>
<ul class="blockListLast">
<li class="blockList">
<h4>join</h4>
<pre>public&nbsp;void&nbsp;join(long&nbsp;shutdownTimeoutMS)</pre>
</li>
</ul>
</li>
</ul>
</li>
</ul>
</div>
</div>
<!-- ========= END OF CLASS DATA ========= -->
<!-- ======= START OF BOTTOM NAVBAR ====== -->
<div class="bottomNav"><a name="navbar.bottom">
<!--   -->
</a>
<div class="skipNav"><a href="#skip.navbar.bottom" title="Skip navigation links">Skip navigation links</a></div>
<a name="navbar.bottom.firstrow">
<!--   -->
</a>
<ul class="navList" title="Navigation">
<li><a href="../../../../overview-summary.html">Overview</a></li>
<li><a href="package-summary.html">Package</a></li>
<li class="navBarCell1Rev">Class</li>
<li><a href="class-use/WorkerService.html">Use</a></li>
<li><a href="package-tree.html">Tree</a></li>
<li><a href="../../../../deprecated-list.html">Deprecated</a></li>
<li><a href="../../../../index-all.html">Index</a></li>
<li><a href="../../../../help-doc.html">Help</a></li>
</ul>
</div>
<div class="subNav">
<ul class="navList">
<li><a href="../../../../org/apache/zookeeper/server/UnimplementedRequestProcessor.html" title="class in org.apache.zookeeper.server"><span class="typeNameLink">Prev&nbsp;Class</span></a></li>
<li><a href="../../../../org/apache/zookeeper/server/WorkerService.WorkRequest.html" title="class in org.apache.zookeeper.server"><span class="typeNameLink">Next&nbsp;Class</span></a></li>
</ul>
<ul class="navList">
<li><a href="../../../../index.html?org/apache/zookeeper/server/WorkerService.html" target="_top">Frames</a></li>
<li><a href="WorkerService.html" target="_top">No&nbsp;Frames</a></li>
</ul>
<ul class="navList" id="allclasses_navbar_bottom">
<li><a href="../../../../allclasses-noframe.html">All&nbsp;Classes</a></li>
</ul>
<div>
<script type="text/javascript"><!--
  allClassesLink = document.getElementById("allclasses_navbar_bottom");
  if(window==top) {
    allClassesLink.style.display = "block";
  }
  else {
    allClassesLink.style.display = "none";
  }
  //-->
</script>
</div>
<div>
<ul class="subNavList">
<li>Summary:&nbsp;</li>
<li><a href="#nested.class.summary">Nested</a>&nbsp;|&nbsp;</li>
<li>Field&nbsp;|&nbsp;</li>
<li><a href="#constructor.summary">Constr</a>&nbsp;|&nbsp;</li>
<li><a href="#method.summary">Method</a></li>
</ul>
<ul class="subNavList">
<li>Detail:&nbsp;</li>
<li>Field&nbsp;|&nbsp;</li>
<li><a href="#constructor.detail">Constr</a>&nbsp;|&nbsp;</li>
<li><a href="#method.detail">Method</a></li>
</ul>
</div>
<a name="skip.navbar.bottom">
<!--   -->
</a></div>
<!-- ======== END OF BOTTOM NAVBAR ======= -->
<p class="legalCopy"><small>Copyright &#169; 2008&#x2013;2021 <a href="https://www.apache.org/">The Apache Software Foundation</a>. All rights reserved.</small></p>
</body>
</html>
