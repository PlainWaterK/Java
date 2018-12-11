// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.ResultSetMetaData;
// import java.sql.Statement;

// public class MakingStatement{
//     public void main(String[] args){
        
//         String sourceURL="";
//         Connection dataBaseConnection = DriverManager.getConnection(sourceURL);
//         Statement statement = dataBaseConnection.createStatement();
//         ResultSet authorNames = statement.executeQuery(
//             "SELECT lastname, firstname FROM authors");

//         ResultSetMetaData metaData = authorNames.getMetaData();
//     }
// };

// public class Authors{
//     Statement stam=null;
//     String lastName,firstName;
//     int id;

//     Authors(){
//     }

//     Authors(int id){
//         init();
//         try{
//             ResultSet rs = stam.executeQuery(
//                 "SELECT lastname, firstname FROM authors where authorId=");
//             while(rs.next){
//                 this.id = id;
//                 this.lastName = rs.getString("lastname");
//                 this.firstName = rs.getString("firstname");
//             } 
//         }catch(Exception e){

//         }
//     }

//     public void remove(){

//     }

    
// }


// /*HashMap hp = new Authors.getAll();
// //LinkedList lt = new LinkedList 
// // 
// // 
// // 
// // 
// */




