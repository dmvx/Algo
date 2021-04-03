//02 - x == y
//03 - x + y <= 29
//06 - x<=10||y<=10
//07 - x>=16&&y>=16
//08 - x<=0||y<=0
//09 - (x-10 >= y)||(x <= y-10)
//11 - (0<y&y<=1)|(0<x&x<=1)|(22<y&y<=23)|(22<x&x<=23)
//13 - ((x < 25)&(y > 18-x))&((x < 25)&(y < 29-x))
//14 - y*x/4<25
//15 - ((x<=y+20)&(x>y+10))|((y<=x+20)&(y>x+10))
//24 - (y == 24-x)|(y==x))


class HarryPaint {
    public static void paintShape() {
        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 25; y++)
                if(((x<=y+20)&(x>y+10))|((y<=x+20)&(y>x+10))){
                    System.out.print("# ");
                }else{
                    System.out.print(". ");
                }
                System.out.println();

        }
    }
}
