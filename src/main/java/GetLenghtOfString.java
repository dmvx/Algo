class GetLenghtOfString {

    public static int getLength(String str)
    {
        int length=0;
        char[] strCharArray=str.toCharArray();
        for(char c:strCharArray)
        {
            length++;
        }
        return length;
    }

}

