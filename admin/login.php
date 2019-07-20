<?php

require './vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\ServiceAccount;

$serviceAccount = ServiceAccount::fromJsonFile('./projectjpmc-firebase-adminsdk-lvq5z-12bc1b3f48.json');

$firebase = (new Factory)
    ->withServiceAccount($serviceAccount)
    ->create();

$database = $firebase->getDatabase();
try {
    $newPost = $database
    ->getReference('user_details')
    ->push([
        'email' => 'Post title',
        'name' => 'This should probably be longer.',
        'token' => 'This should probably be longer.',
        'usercontact' => 55,
        'userImgUrl' => 'This should probably be longer.',
    ]);
    $newPost->getKey(); // => -KVr5eu8gcTv7_AHb-3-
    $newPost->getUri(); // => https://my-project.firebaseio.com/blog/posts/-KVr5eu8gcTv7_AHb-3-
    
    print_r($newPost->getValue()); // Fetches the data from the realtime database
} catch (ClientException $e) {
    // catches all ClientExceptions
} catch (RequestException $e) {
    // catches all RequestExceptions
    print_r($e);
}







?>