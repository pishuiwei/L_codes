hostname=$(cat /proc/sys/kernel/hostname)

env="uat"
#env="pro"

#project="Jumper"
project="Rnd-Jumper"

log_type="connectionHistory"

if [[ $env = "uat" ]]; then
	echo "uat"
	sftp_host="g.sftp.ifa.inhuawei.com"
	sftp_port=10037
	sftp_user="Bigdata_Upload_CloudSSH"
	sftp_pwd="Upload_CloudSSH666"
	if [[ $project = "Jumper" ]]; then
		echo "project: Jumper"
		mysql_host="172.30.78.40"
		mysql_user="root"
		mysql_pwd="Huawei;0"
	else if [[ $project = "Rnd-Jumper" ]]; then
		echo "project: Rnd-Jumper"
		mysql_host="100.101.8.153"
		mysql_user="root"
		mysql_pwd="Huawei;0"
	else
		echo "unknown project $project"
	fi
	fi
else if [[ $env = "pro" ]]; then
	echo "pro"
	sftp_host="sc-ueba.huawei.com"
	sftp_port=10022
	sftp_user="Bigdata_Upload_CloudSSH"
	sftp_pwd="Azwert_Upload_CloudSSH865"
	if [[ $project = "Jumper" ]]; then
		echo "project: Jumper"
		mysql_host="10.1.247.91"
		mysql_user="dbAdmin"
		mysql_pwd="hwpsis#123"
	else if [[ $project = "Rnd-Jumper" ]]; then
		echo "project: Rnd-Jumper"
		mysql_host="100.101.9.241"
		mysql_user="root"
		mysql_pwd="Huawei;0"
	else
		echo "unknown project $project"
	fi
	fi
else
	echo "unknown env"
	sendEmail "[ERROR] unknown env $env! "
fi
fi

file_prefix=/tmp/

#date_yesterday=$(date -d "yesterday" +%Y-%m-%d)
#file_name=connection_history_${date_yesterday}.txt
time_now=$(date "+%Y%m%d-%H%M%S")
file_name=connection_history_${time_now}.txt

destFile=${file_prefix}${file_name}
targetPath=CloudSSH/$project/$log_type/

emailList="fuqiang43@huawei.com,pishuiwei1@huawei.com"

sendEmail(){
        if [ ! -f "$2" ]; then
                echo "$2" | mailx -s "$1" $emailList
        else
                 mailx -s "$1" $emailList < "$2"
        fi
}

if [ $(rpm -qa|grep -c expect ) -ne 1 ];then
       yum -y install expect
fi

/usr/bin/expect <<-EOF
#!/usr/bin/expect
set timeout 600
spawn mysql -u$mysql_user -p -h $mysql_host
log_file $destFile
expect "Enter password:"
send "$mysql_pwd\r"
expect "mysql>"
log_user 1
send "SELECT username,connection_name,start_date,end_date,source,target FROM guacamole.guacamole_connection_history WHERE (TO_DAYS(NOW()) - TO_DAYS(end_date) < 1) AND (end_date - start_date > 10);\r"
expect "mysql>"
log_user 0
send "quit\r"
expect eof
EOF

uploadBigData() {
		/usr/bin/expect <<-EOF
		#!/usr/bin/expect
		set timeout 300
		spawn sftp -oPort=$sftp_port $sftp_user@$sftp_host:$targetPath
		expect {
		"*yes/no" { send "yes\r"; exp_continue }
		"*password:" { send "$sftp_pwd\r" }
		}
		send "$sftp_pwd\r"
		expect "sftp>"
		send "put $destFile\r"
		expect "sftp>"
		send "exit\n"
		expect eof
		EOF
}

last=$(sed -n '$=' $destFile)
sed ''"$(($last-3+1))"',$d' -i $destFile

if [ ! -f $destFile ]; then
    sendEmail "[ERROR] $destFile not exists!  $mysql_host fail to upload log to big data platform! "
else
  	uploadBigData
fi
