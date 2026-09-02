package rianaLibraries.repos;

public class Caller {
    public static void getTrace(){
        Thread.currentThread().getStackTrace()[2].getClassName();
        Thread.currentThread().getStackTrace()[2].getMethodName();
        Thread.currentThread().getStackTrace()[2].getFileName();
    }


      public static String getCallerClassName(){
          StackTraceElement[] stElements=Thread.currentThread().getStackTrace();
          String callerClassName=null;
          /*for (int i=1;i< stElements.length;i++){
              StackTraceElement ste=stElements[i];
              if(!ste.getClassName().equals(KDebug.class.getName())) && ste.getClassName().indexOf("java.lang.Thread")!=0){
                    //Samsung got off
              }
          }*/
          return "We will continue next time";
      }

}
