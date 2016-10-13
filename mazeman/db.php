<?
   $hostName = "localhost";
   $databaseName = "web";
   $username = "webuser";
   $password = "w0506r";

  function clean($input, $maxlength)
 {
     $input = substr($input, 0, $maxlength);
    $input = EscapeShellCmd($input);
   return ($input);
  }
?>
