package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }



    public boolean shoot(String shot) {




        int y = shot.charAt(1) - '0';
        int indexOfShot = 0;

        switch(shot.charAt(0)) {
            case 'A': indexOfShot = (y-1)*8;
                break;

            case 'B': indexOfShot = 1 + (y-1)*8;
                break;

            case 'C': indexOfShot = 2 + (y-1)*8;
                break;

            case 'D': indexOfShot = 3 + (y-1)*8;
                break;

            case 'E': indexOfShot = 4 + (y-1)*8;
                break;

            case 'F': indexOfShot = 5 + (y-1)*8;
                break;

            case 'G': indexOfShot = 6 + (y-1)*8;
                break;

            case 'H': indexOfShot = 7 + (y-1)*8;
                break;
        }

        StringBuilder str = new StringBuilder("0000000000000000000000000000000000000000000000000000000000000000");
        str.setCharAt(indexOfShot, '1');

        this.shots = this.shots | Long.parseUnsignedLong(str.toString(), 2);







        StringBuilder shipsBuilder = new StringBuilder("");

        if (Long.toBinaryString(ships).length() < 64)

        {
            for (int i =Long.toBinaryString(ships).length(); i < 64; i++)
            {
                shipsBuilder.append(0);

            }

        }
        shipsBuilder.append(Long.toBinaryString(this.ships));






        if (str.charAt(indexOfShot) == shipsBuilder.charAt(indexOfShot))
        {
            return true;
        }
        return false;



    }

    public String state() {

        StringBuilder str = new StringBuilder("");




        StringBuilder shotsBuilder = new StringBuilder("");
        StringBuilder shipsBuilder = new StringBuilder("");

        if (Long.toBinaryString(ships).length() < 64)

        {
            for (int i =Long.toBinaryString(ships).length(); i < 64; i++)
            {
                shipsBuilder.append(0);

            }

        }
        shipsBuilder.append(Long.toBinaryString(this.ships));


        if (Long.toBinaryString(shots).length() < Long.toBinaryString(ships).length())

        {
            for (int i = Long.toBinaryString(shots).length(); i < Long.toBinaryString(ships).length(); i++)
            {
                shotsBuilder.append(0);
            }

        }

        if (Long.toBinaryString(shots).charAt(Long.toBinaryString(shots).length()-1) == '1')
        {
            shotsBuilder.append(0);
        }
        shotsBuilder.append(Long.toBinaryString(shots));







        int k = 1;
        for (int i = 0; i < shotsBuilder.length(); i++, k++)
        {

            if (shipsBuilder.charAt(i) == shotsBuilder.charAt(i) && shipsBuilder.charAt(i) == '1')
            {
                str.append("☒");
            }
            else
            if (shipsBuilder.charAt(i) == shotsBuilder.charAt(i) && shipsBuilder.charAt(i) == '0')
            {
                str.append(".");
            }
            else
            if (shipsBuilder.charAt(i) == '1')
            {
                str.append("☐");
            }
            else
            if (shotsBuilder.charAt(i) == '1' && shipsBuilder.charAt(i) == '0')
            {
                str.append("×");
            }



            if (k % 8 == 0)
            {
                str.append("\n");
            }

        }



        return str.toString();

        //return Long.toBinaryString(this.ships);

    }
}
