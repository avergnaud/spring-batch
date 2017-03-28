
TROUBLESHOOTING :
"Step already complete or not restartable, so no action to execute"
> JobLauncher vers JobOperator

"No job configuration with the name [restartableJobTest] was registered"
> manque le jobRegistryBeanPostProcessor

"No job parameters incrementer found for job=simpleJob"
> incrementer="jobParametersIncrementer" dans le xml

sudo service mysql stop
sudo service mysql status
sudo service mysql start

mysql -u root -p
root

use springbatchdb;

(CREATE DATABASE springbatchdb CHARACTER SET utf8 COLLATE utf8_general_ci ; )

Table 'springbatchdb.BATCH_JOB_INSTANCE' doesn't exist
	spring-batch-core*.jar
		batch.schema.script=classpath:/org/springframework/batch/core/schema-mysql.sql
		batch.drop.script=classpath:/org/springframework/batch/core/schema-drop-mysql.sql

(mysql)
source /home/ubuntu/dev/springbatch/workspace_formation/MetaData/schema-mysql.sql
http://docs.spring.io/spring-batch/reference/html/metaDataSchema.html

mysql> show tables;
+------------------------------+
| Tables_in_springbatchdb      |
+------------------------------+
| BATCH_JOB_EXECUTION          |
| BATCH_JOB_EXECUTION_CONTEXT  |
| BATCH_JOB_EXECUTION_PARAMS   |
| BATCH_JOB_EXECUTION_SEQ      |
| BATCH_JOB_INSTANCE           |
| BATCH_JOB_SEQ                |
| BATCH_STEP_EXECUTION         |
| BATCH_STEP_EXECUTION_CONTEXT |
| BATCH_STEP_EXECUTION_SEQ     |
+------------------------------+
9 rows in set (0,00 sec)


http://docs.spring.io/spring-batch/reference/htmlsingle/#configuringJobRepository

