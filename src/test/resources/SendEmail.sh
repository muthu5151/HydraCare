#!/bin/bash
sesAccess='sonaimuthu.alagarsamy@qualitestgroup.com'
sesSecret='jgnzjqdwkwtyxksj'
sesFromName="Sonaimuthu Alagarsamy"
sesFromAddress="sonaimuthu.alagarsamy@qualitestgroup.com"
sesToAddress="$4"
sesSubject="Subject:Hydracare Tests"
sesSMTP="smtp.office365.com"
sesPort="587"
sesMessage=$'This is an auto-generated email'
sesFile="$1"
sesMIMEType=`file --mime-type "$sesFile" | sed 's/.*: //'`

mails=$(echo $sesToAddress | tr ";" "\n")
a='--mail-rcpt'
c=''
for addr in $mails
do
    b="$addr"
    c="${c} ${a} ${b}"
done
echo ${c}
curl -v --url smtp://$sesSMTP:$sesPort --ssl-reqd  --mail-from $sesFromAddress ${c} --user $sesAccess:$sesSecret -F '=(;type=multipart/mixed' -F "=$sesMessage;type=image/png" -F "file=@$sesFile;type=$sesMIMEType;encoder=base64" -F '=)' -H "Subject: $sesSubject" -H "From: $sesFromName <$sesFromAddress>" -H "To: <$sesToAddress>"
