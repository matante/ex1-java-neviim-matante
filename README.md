[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7320627&assignment_repo_type=AssignmentRepo)
# EX1 - JAVA
In this program I built a scrapper to scrap on an URL, and write the results to a file.

<h1>Author(s)</h1>
<ol>
<li>Matan Tenenboim, matante@edu.hac.ac.il</li>
</ol>

<h1>1. Compilation</h1>
<p>Use the IntelliJ configuration to build the project.</p>

<h1>2. Execution</h1>
<p>as described in the instructions page:<br>
"&lt options &gt &lt url &gt &lt outputfile &gt"<br>

for example:
-hia https://docs.oracle.com/en/java/javase/17/docs/api/index.html out3 <br>
if running from terminal:<br>
java Main -hia https://docs.oracle.com/en/java/javase/17/docs/api/index.html out3

</p>
<h2>Configurations</h2>
<p>this program using JSOUP library!! I installed it for this project, so I guess nothing else should be done. if your IDE don't have JSOUP installed as described in the instructions page, I don't know what will happen</p>
<h2>Terminal based execution</h2>
<p>List here the command line syntax and expected parameters.</p>
<p>For example, open a terminal and:</p>
<pre>
cd out/production/&lt;dirname&gt;<br/>
java Main -hia https://docs.oracle.com/en/java/javase/17/docs/api/index.html out3
</pre>
<h1>3. Documentation</h1>
<p>Link to <a href="#">project API (javadoc)</a>.</p>
Link didn't work, check JavaDoc folder.

<h1>4. Tests and input files</h1>
<p>
For the same test files we got from the lecturer for this project, and the results should be the same.<br>
Note that for test5, there is some link which generated for each user in this web, so it will be different.

</p>
<h1>4. Assumptions</h1>
<p>
  I opened the file for append and closed it each time.
</p>