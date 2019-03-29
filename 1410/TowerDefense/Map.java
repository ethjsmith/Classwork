public class Map extends TDobj {
    //array that represents the field :
    // have to decide resolution and stuff

    int gamearray [][];
    int mapx;
    int mapy;

    public Map() {
        super();
        mapx =10;
        mapy =10;
        gamearray = new int [mapx][mapy];
        setmap();
    }
    public void setmap() {
        //sets up the Map/
        // for now just makes a static map

        for (int x=0;x<mapx;x++) {
            for (int y=0;y<mapy;y++) {
                gamearray[x][y] = 1;
            }
        }
    }
    // prints out a visual representation of the map//
    // // // // // // // // // // // // // // // // //
    public void printmap() {
        for (int x=0;x<mapx;x++) {
            for (int y=0;y<mapy;y++) {
                System.out.print(gamearray[x][y] + " ");
            }
            System.out.println("");
        }
    }
	public int getPos(int x,int y) {
		return gamearray[x][y];
	}
}
