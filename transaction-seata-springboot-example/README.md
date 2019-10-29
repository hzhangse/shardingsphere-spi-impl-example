# shardingsphere-spi-impl-example

integrate seata 0.7.1+ springboot 2.1.0 + undo_log.sql

in traditonal transaction mode, shadingsphere can rollback with sharding datasouce connection ,but limit on retry function 

in seata transaction mode, the commit or rollback action can be cordinate by seats server and retry when failed once. 