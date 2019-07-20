<?php

require './vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\ServiceAccount;

$serviceAccount = ServiceAccount::fromJsonFile('./projectjpmc-firebase-adminsdk-lvq5z-12bc1b3f48.json');

$firebase = (new Factory)
    ->withServiceAccount($serviceAccount)
    ->create();

$database = $firebase->getDatabase();
    $newPost = $database
    ->getReference('Beginners')->getChild('Students');
/*    ->push([
        'email' => 'Post title',
        'name' => 'This should probably be longer.',
        'token' => 'This should probably be longer.',
        'usercontact' => 55,
        'userImgUrl' => 'This should probably be longer.',
    ]);
    $newPost->getKey(); // => -KVr5eu8gcTv7_AHb-3-
    $newPost->getUri(); // => https://my-project.firebaseio.com/blog/posts/-KVr5eu8gcTv7_AHb-3-
  */$jsonString= json_encode($newPost->getValue()); // Fetches the data from the realtime database
    
    $jsonDecoded = json_decode($jsonString,True);
    //unset($jsonDecoded[0]);
    //array_values($jsonDecoded);
    $jsonDecoded[0] = Array("age","attendance","gr1","gr2","gr3","gr4","gr5","mobile","name","roll","saving","total");
    print_r($jsonDecoded);

    $csvFileName = 'Beginners_Students.csv';
 
    //Open file pointer.
    $fp = fopen($csvFileName, 'w');
     
    //Loop through the associative array.
    foreach($jsonDecoded as $row){
        //Write the row to the CSV file.
        fputcsv($fp, $row);
    }
     
    //Finally, close the file pointer.
    fclose($fp);
    



?>