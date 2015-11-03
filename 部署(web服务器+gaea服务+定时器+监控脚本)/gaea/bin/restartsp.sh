o "---- start restart sphofan all gaea service ----"


echo "start restart advise"
/opt/gaea/bin/restart.sh spadviseservice 1
echo "end restart advise"
sleep 1s

echo "start restart erp"
/opt/gaea/bin/restart.sh sperpservice 1
echo "end restart erp"
sleep 1s

echo "start restart purchase..."
/opt/gaea/bin/restart.sh sppurchaserservice 1
echo "end restart purchase..."
sleep 1s

echo "start restart menu..."
/opt/gaea/bin/restart.sh spmenuservice 1
echo "end restart menu..."
sleep 1s

echo "start restart supplier..."
/opt/gaea/bin/restart.sh spsuppliersservice 1
echo "end restart supplier..."
sleep 1s

echo "start restart reconc..."
/opt/gaea/bin/restart.sh spreconciliationservice 1
echo "end restart reconc..."

echo "---- end restart sphofan all gaea service ----"
