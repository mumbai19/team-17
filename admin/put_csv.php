<?php

require './vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\ServiceAccount;

$serviceAccount = ServiceAccount::fromJsonFile('./projectjpmc-firebase-adminsdk-lvq5z-12bc1b3f48.json');

$firebase = (new Factory)
    ->withServiceAccount($serviceAccount)
    ->create();

    $array = $fields = array(); $i = 1;
$handle = @fopen('Beginners_Students.csv', "r");
$array[0]=null;
if ($handle) {
    while (($row = fgetcsv($handle, 4096)) !== false) {
        if (empty($fields)) {
            $fields = $row;
            continue;
            
        }
        foreach ($row as $k=>$value) {
            if($fields[$k]=="roll"){

            }
            else if(is_numeric($value)){
                $value=(int)$value;
            }
            $array[$i][$fields[$k]] = $value;
        }
        $i++;
    }
    if (!feof($handle)) {
        echo "Error: unexpected fgets() fail\n";
    }
    fclose($handle);
}
array_values($array);

$database = $firebase->getDatabase();
    $newPost = $database
    ->getReference('Beginners')->getChild('Students')
    ->set($array);
    /*$newPost->getKey(); // => -KVr5eu8gcTv7_AHb-3-
    $newPost->getUri(); // => https://my-project.firebaseio.com/blog/posts/-KVr5eu8gcTv7_AHb-3-
  /*$jsonString= json_encode($newPost->getValue()); // Fetches the data from the realtime database
    
    $jsonDecoded = json_decode($jsonString,True);
    //unset($jsonDecoded[0]);
    //array_values($jsonDecoded);
    $jsonDecoded[0] = Array("age","attendance","mobile","name","roll","saving","total");
    print_r($jsonDecoded);

    /*$csvFileName = 'Beginners_Students.csv';
 
    //Open file pointer.
    $fp = fopen($csvFileName, 'w');
     
    //Loop through the associative array.
    foreach($jsonDecoded as $row){
        //Write the row to the CSV file.
        fputcsv($fp, $row);
    }
     
    //Finally, close the file pointer.
    fclose($fp);
    


*/

//print_r($_POST['files']);
?>