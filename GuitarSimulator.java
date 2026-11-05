/**
 * This GuitarSimulator object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarSimulator
{
    public static void main(String[] args) 
    {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] notes = new GuitarString[37];
        for(int i = 0; i<37; i++)
        {
            notes[i] = new GuitarString(440 * Math.pow(1.05956, i-24));
        }
        while(true)
        {
            if (StdDraw.hasNextKeyTyped()) 
            {
                char key = StdDraw.nextKeyTyped();
                for(int i = 0; i<37; i++)
                {
                    if(key == keyboard.charAt(i))
                    {
                        notes[i].pluck();
                    }
                }
            }
            double sample = 0;
            for(int i = 0; i<37; i++)
            {
                sample+= notes[i].sample();
            }
            StdAudio.play(sample);
            for(int i = 0; i<37; i++)
            {
                notes[i].tic();
            }

        }

    }
}

