<?php


// check that the tag is present
if (isset($_POST['tag']) && $_POST['tag'] != '') {
    
    $tag = $_POST['tag'];

    // Create a connection the the database and table
    $error = 'Could not connect to the database';
    //Depending on your setup you might need to change the below for your own credentials
	mysql_connect('localhost','root','Mindrot_1') or die ($error);
	mysql_select_db('remote_db') or die ($error);

   

    // check if tag = 'getAge'
    if ($tag == 'getAge') {
        
        //Get name 
        $name = $_POST['name'];
		
		//Select records from the database
		$find = mysql_query("SELECT * FROM users WHERE user_name='$name'");
		
		//check that records exist
        if (mysql_num_rows($find)>0) {
		
          while ($find_row = mysql_fetch_assoc($find))
		{
			//Get user age
			$age = $find_row['user_age'];
		}
			//Return the response as a success, including age.
		    $response["success"] = 1;
            $response["user"]["name"] = $name;
            $response["user"]["age"] = $age;
            echo json_encode($response);
            }
         else {
			//Return error
			$response["success"] = 0;
            $response["error"] = 1;
            $response["error_msg"] = "User could not be found";
             echo json_encode($response);
		 }
    } else {
        echo "No action for the tag";
    }
} else {
    echo "Unknown error";
}
?>
