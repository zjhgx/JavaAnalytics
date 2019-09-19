Apache HBase™ is the Hadoop database, a distributed, scalable, big data store.

Use Apache HBase™ when you need random, realtime read/write access to your Big Data. This project's goal is the hosting of very large tables -- billions of rows X millions of columns -- atop clusters of commodity hardware. Apache HBase is an open-source, distributed, versioned, non-relational database modeled after Google's Bigtable: A Distributed Storage System for Structured Data by Chang et al. Just as Bigtable leverages the distributed data storage provided by the Google File System, Apache HBase provides Bigtable-like capabilities on top of Hadoop and HDFS. 

## Features

    Linear and modular scalability.
    Strictly consistent reads and writes.
    Automatic and configurable sharding of tables
    Automatic failover support between RegionServers.
    Convenient base classes for backing Hadoop MapReduce jobs with Apache HBase tables.
    Easy to use Java API for client access.
    Block cache and Bloom Filters for real-time queries.
    Query predicate push down via server side Filters
    Thrift gateway and a REST-ful Web service that supports XML, Protobuf, and binary data encoding options
    Extensible jruby-based (JIRB) shell
    Support for exporting metrics via the Hadoop metrics subsystem to files or Ganglia; or via JMX
    
## Data Model
In HBase, data is stored in tables, which have rows and columns. This is a terminology overlap with relational databases (RDBMSs), but this is not a helpful analogy. Instead, it can be helpful to think of an HBase table as a multi-dimensional map.


Each column family may have its own rules regarding how many versions of a given cell to keep (a cell is identified by its rowkey/column pair) In most cases, applications will simply ask for a given cell's data, without specifying a timestamp. In that common case, HBase/BigTable will return the most recent version (the one with the highest timestamp) since it stores these in reverse chronological order.

If an application asks for a given row at a given timestamp, HBase will return cell data where the timestamp is less than or equal to the one provided.
