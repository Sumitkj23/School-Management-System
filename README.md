# School-Management-System
Java Swing Project With JDBC

download some jar file
1. sqlite-jdbc-3.20.0.jar   // jdbc driver  
2. jCalendar-1.4.jar        // jDateChooser for 'issue book date' & 'return book date'
3. JTattoo-1.6.13.jar       // for attractive look and feel

            Add all these library add into project
----------------------------------------------------------------------------------------------------------------------
    
package & classes -:

    Account - Login.java (main function), User.java
    Helper - javaConnect.java
    Action - Admin_Home.java, Teacher_Home.java, Classes.java, Subject.java, Exam.java, Student.java, Teacher.java     
-----------------------------------------------------------------------------------------------------------------------

Database info -:

    use sqlite database
    database name   :   School_Management.sqlite
    path  :   src\\School_Management.sqlite
----------------------------------------------------------------------------------------------------------------------

Database Table With Column Description -:

    'User' : Username(Primary key), Name, Password, User_Type, Contact_No, Address
    
    'Class'   : Name, Section
    
    'Subject' : Id(Primary key), Name
    
    'Exam'    : Exam_Name, Shift, Date
    
    'Student' : Id(Primary key), Name, F_Name, DOB, Gender, Contact, Address, Class, Section
    
    'Teacher' : id(Primary key), Name, Qualification, Salary, Contact, Email
    
---------------------------------------------------------------------------------------------------------------------------------------

Class Description -:

    #javaConnect.java  :   having static method 'connectDb' for establising connection with database 'School_Management'
    
                                ------------------------------------------
    
    #Login.java    :   having 2 button 'Login', 'Exit'
    
            Login Button : fetch data from 'User' table and check user exist or not, 
                          if user exist then open(according to usertype) 'Admin_Home.java' or 'Teacher_Home.java' class
                              with passing the username and usertype into constructor
                              --------------------------------------------
                      
    #Admin_Home.java   :   Open menu for 'Class', 'Subject', 'Exam', 'Student', 'Teacher', 'New User'
                    These all are jButton, by clicking on this button it perform operation as given name
                    
                              ----------------------------------------------
                              
    #Teacher_Home.java   :   Open menu for 'Class', 'Subject', 'Student'
                    These all are jButton, by clicking on this button it perform operation as given name
                    
                              ----------------------------------------------
                              
                              
                    
            Class Button calls 'Classes.java'
    #Classes.java   :   Take new class information and add into 'Class' table
                        and also Show all previous added class info in jTable 
                          by fetching the data from 'Class' table
                            
                              ------------------------------------------------
    
            Subject Button calls 'Subject.java'
    #Subject.java   :   Take new Subject information and add into 'Subject' table
                        and also Show all previous added Subject info in jTable 
                          by fetching the data from 'Subject' table
                            
                             -------------------------------------------------
                    
            Exam Button call 'Exam.java'
    #Exam.java   :   Take Exam information and add into 'Exam' table
                     and also Show all previous added Exam info in jTable 
                          by fetching the data from 'Exam' table
                            
                             -------------------------------------------------
                            
            Student Button calls 'Student.java'
    #Student.java   :   Take data for add new student in School
                        all the data save into 'Student' table
                 
                            --------------------------------------------------
                        
            Teacher Button calls 'Teacher.java'
    #Teacher.java   :   Take data for add new Teacher in School
                        all the data save into 'Teacher' table
                 
                            --------------------------------------------------
                            
            New User button call 'User.java'
    #User.java   :   create new user and all the information save into 'User' table
    
    ------------------------------------------------------------------------------------------------------------------------------
    
                  If you like this project or helpful for you then you plese give an star to this project
                                                    Thankyou!!!
