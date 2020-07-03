## Document Database
A record in MongoDB is a document, which is a data structure composed of field and value pairs. MongoDB documents are similar to JSON objects. The values of fields may include other documents, arrays, and arrays of documents.

![](https://docs.mongodb.com/manual/_images/crud-annotated-document.bakedsvg.svg)

The advantages of using documents are:

* Documents (i.e. objects) correspond to native data types in many programming languages.
* Embedded documents and arrays reduce need for expensive joins.
* Dynamic schema supports fluent polymorphism.

MongoDB stores documents in collections. Collections are analogous to tables in relational databases.
n addition to collections, MongoDB supports:
* Read-only Views (Starting in MongoDB 3.4)
* On-Demand Materialized Views (Starting in MongoDB 4.2).

### Key Features
__High Performance__

MongoDB provides high performance data persistence. In particular,

__Rich Query Language__

MongoDB supports a rich query language to support read and write operations (CRUD) as well as:

* Data Aggregation
* Text Search and Geospatial Queries.

Support for embedded data models reduces I/O activity on database system.
Indexes support faster queries and can include keys from embedded documents and arrays.

__High Availability__
MongoDB’s replication facility, called replica set, provides:
* automatic failover
* data redundancy.
A replica set is a group of MongoDB servers that maintain the same data set, providing redundancy and increasing data availability.

__Horizontal Scalability__
MongoDB provides horizontal scalability as part of its core functionality:
* Sharding distributes data across a cluster of machines.
* Starting in 3.4, MongoDB supports creating zones of data based on the shard key. In a balanced cluster, MongoDB directs reads and writes covered by a zone only to those shards inside the zone. See the Zones manual page for more information.

__Support for Multiple Storage Engine__
MongoDB supports multiple storage engines:
* WiredTiger Storage Engine (including support for Encryption at Rest)
* In-Memory Storage Engine.



## Working with the mongo Shell
To display the database you are using, type db:
````
db
````
To switch databases, issue the use <db> helper, as in the following example:
```
use <database>
```
To list the databases available to the user, use the helper show dbs. [1]

You can switch to non-existing databases. When you first store data in the database, such as by creating a collection, MongoDB creates the database. For example, the following creates both the database myNewDatabase and the collection myCollection during the insertOne() operation:

````
use myNewDatabase
db.myCollection.insertOne( { x: 1 } );
````
* db refers to the current database.
* myCollection is the name of the collection. 
If the mongo shell does not accept the name of a collection, you can use the alternative db.getCollection() syntax. For instance, if a collection name contains a space or hyphen, starts with a number, or conflicts with a built-in function:
````
db.getCollection("3 test").find()
db.getCollection("3-test").find()
db.getCollection("stats").find()
````

### Format Printed Results
The db.collection.find() method returns a cursor to the results; however, in the mongo shell, if the returned cursor is not assigned to a variable using the var keyword, then the cursor is automatically iterated up to 20 times to print up to the first 20 documents that match the query. The mongo shell will prompt Type it to iterate another 20 times.
````
db.myCollection.find().pretty()
````
In addition, you can use the following explicit print methods in the mongo shell:
* print() to print without formatting
* print(tojson(<obj>)) to print with JSON formatting and equivalent to printjson()
* printjson() to print with JSON formatting and equivalent to print(tojson(<obj>))

### Multi-line Operations in the mongo Shell
If you end a line with an open parenthesis ('('), an open brace ('{'), or an open bracket ('['), then the subsequent lines start with ellipsis ("...") until you enter the corresponding closing parenthesis (')'), the closing brace ('}') or the closing bracket (']'). The mongo shell waits for the closing parenthesis, closing brace, or the closing bracket before evaluating the code, as in the following example:
````
 if ( x > 0 ) {
... count++;
... print (x);
... }

````
You can exit the line continuation mode if you enter two blank lines, as in the following example:

````
> if (x > 0
...
...
>
````

### Tab Completion and Other Keyboard Shortcuts
* Use the up/down arrow keys to scroll through command history. See .dbshell documentation for more information on the .dbshell file.
* Use <Tab> to autocomplete or to list the completion possibilities, as in the following example which uses <Tab> to complete the method name starting with the letter 'c':
````
db.myCollection.c<Tab>
````

## Customize the Promp
### Customize Prompt to Display Number of Operation
For example,to create a mongo shell prompt with the number of operations issued in the current session, define the following variables in the mongo shell:
````
cmdCount = 1;
prompt = function() {
             return (cmdCount++) + "> ";
         }
````
The prompt would then resemble the following:
````
1>
2>
3>
````

### Customize Prompt to Display Database and Hostname

To create a mongo shell prompt in the form of <database>@<hostname>$, define the following variables:

````
host = db.serverStatus().host;

prompt = function() {
             return db+"@"+host+"$ ";
         }
````
The prompt would then resemble the following:

````
test@myHost1$
````

### Command Line Help
To see the list of options and help for starting the mongo shell, use the --help option from the command line:
````
mongo --help
````

### Shell Help
To see the list of help, in the mongo shell, type help:
````
help
````

### Database Help





