#!/bin/bash
host=$1
port=$2
key_pre=$3
file=$4
redis_cli_dir=$5
if [ $# -ne 5 ];then
	echo "Usage: $0 ip port pre_pre file redis_cli_dir"
	exit
fi
write_file=$(${redis_cli_dir}/redis-cli -c -h $host -p $port --scan --pattern "${key_pre}*" >$file)
$write_file
cat $file|while read line
do
${redis_cli_dir}/redis-cli -c -h $host -p $port del $line
echo $line
done

#sh del_redis_keys.sh 192.168.110.233 7379 risk node1.log /opt/supp_app/redis_3.0 