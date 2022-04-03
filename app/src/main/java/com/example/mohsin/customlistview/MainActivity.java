package com.example.mohsin.customlistview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
//    Tourist sites
    String mTitle[] = {"Sipi Falls", "Lake Bunyonyi", "Murchison Falls", "Kidepo Park", "Mhahinga Park", "Lake Victoria", "Ssese Islands", "Bwindi Impenetrable National Park", "Entebbe", "Queen Elizabeth National Park", "Mount Elgon National Park", "Lake Mburo National Park", "Kibale National Park"};
//    toursit site location
    String mLocation[] = {"Mbale District", "Mbarara District", "Pakwach District", "Karamoja Region", "Kisoro District", "Jinja District", "Kalangala District", "Kisoro", "Entebbe", "PortPortal", "Mbale", "Mbarara", "Kibale"};
//   Images for a preview
    int images[] = {R.drawable.sipi, R.drawable.bunyonyi, R.drawable.murchison_1, R.drawable.kidepo, R.drawable.mhahiga, R.drawable.victoria, R.drawable.ssesse, R.drawable.bwindi, R.drawable.entebbe, R.drawable.queen, R.drawable.elgon, R.drawable.mburo, R.drawable.kibale};
    // so our images and other things are set in array

//Phone numbers
    String mPhoneNumbers[] = {
            "0773012311", "0773123112","0773012313", "0773123114","0773012115", "0773123116","0773012311", "0773123112","0773012313", "0773123114","0773012115", "0773123116", "0773123116"
    };

//    simple sample description
    String mDescription[] = {
            "Sipi Falls is a waterfall found at the foot hills of Mountain Elgon just at the edge of Mount Elgon National Park. The falls are one of the most awe-inspiring sights in Eastern Uganda.",
            "Lake Bunyonyi is in south-western Uganda between Kisoro and Kabale, and it is close to the border with Rwanda. The lake appeared from 2004 to 2009 on the 5,000 Ugandan shilling note under the title \"Lake Bunyonyi and terraces\"",
            "Murchison Falls National Park sits on the shore of Lake Albert, in northwest Uganda. It’s known for Murchison Falls, where the Victoria Nile River surges through a narrow gap over a massive drop. Park wildlife includes elephants and hippos, and there are chimpanzees in the Kaniyo Pabidi mahogany forest. The Lake Albert Delta is home to rare shoebill storks. There are game fish in the cascades of Karuma Falls",
            "The Kidepo River is a seasonal river along the Kidepo Valley in the Karamoja region of Uganda, and in East Equatoria area of South Sudan.",
            "Mgahinga Gorilla National Park sits high in the clouds, at an altitude of between 2,227m and 4,127m. As its name suggests, it was created to protect the rare mountain gorillas that inhabit its dense forests, and it is also an important habitat for the endangered golden monkey.",
            "Lake Victoria is one of the African Great Lakes. Though having multiple local language names, the lake was renamed after Queen Victoria by the explorer John Hanning Speke, the first Briton to document it in 1858, while on an expedition with Richard Francis Burton",
            "A cocktail of golden sands worthy of Latin America, sun-kissed beaches and lapping waves, the archipelago of the Ssese Islands is Uganda’s answer to the tropical gems of the East African coast on the Indian Ocean.\n" +
                    "\n" +
                    "Peppering the waters of Lake Victoria, they are considered the country’s premier rest and relaxation spot, with the popular Buggala Island and Bulago coming up top of the menu.\n" +
                    "\n" +
                    "You can either kick-back in one of the lakeside resorts, or wax up the walking boots and make for the hills, where hippo-dotted swamps hide between the ridges.\n" +
                    "\n" +
                    "Kayaks and other watersports are also available on Buggala",
            "The Bwindi Impenetrable National Park really does live up to its name! A land of rocky peaks and endless green, it’s covered in some of Africa’s oldest primeval forestry.\n" +
                    "\n" +
                    "The biodiversity – think geckos next to gorillas next to a multitude of curious insects – garnered the spot a UNESCO World Heritage tag, while most safari goers head this way in search of colobus monkeys and chimpanzees.\n" +
                    "\n" +
                    "The breathtaking landscapes are typical of the Albertine Rift.\n" +
                    "\n" +
                    "They rise and fall to untrodden valleys and summits, with quartzite massifs here and teak-shrouded riverways there.\n" +
                    "\n" +
                    "It’s definitely one to write home about!\n" +
                    "\n",
            "Entebbe, for most international visitors at least, will be the entrance point to Uganda.\n" +
                    "\n" +
                    "It’s here that the nation’s Entebbe International Airport makes its home; its runways butting up against the waters of Lake Victoria.\n" +
                    "\n" +
                    "Most will also leave promptly, on their way to Kampala or the country’s other far-flung safari destinations.\n" +
                    "\n" +
                    "Those who linger can enjoy a laid-back place that still trundles to the tune of the old British Protectorate – for it’s here that the English colonists made their base in earlier decades.\n" +
                    "\n" +
                    "One of the relics of that age is the beautiful National Botanical Gardens, while there are also charming churches, and the official residence of the president: the Ugandan State House.",
            "Handily named just QENP for short, this huge dash of wilderness that lies close to the banks of Lake Edward and the DRC border in the west is Uganda’s most famous national park.\n" +
                    "\n" +
                    "It’s visited by thousands of tourists each year, who come in search of the lazy Congo lions and the swinging chimps that can be seen mingling between the Maramagambo Forest and the grassy savannah.\n" +
                    "\n" +
                    "The whole area is also scarred by countless volcanic features, going from the awesome Katwe craters to great rifts in the earth, making it an interesting and eye-catching place to go on safari drives and game seeking journeys.",
            "The rock-ribbed, jungle-topped highlands of the Mount Elgon National Park are peppered with so many natural beauties it can be difficult to describe them all at once.\n" +
                    "\n" +
                    "Cascading down from the extinct caldera of one of Africa’s oldest volcanos, there are waterfalls, dank cave systems, and rugged canyons aplenty.\n" +
                    "\n" +
                    "Visitors can also feel the geothermal activity at a series of hot springs, or wonder upwards, to where African goshawks and elegant bush-shrikes flit through the skies.\n" +
                    "\n" +
                    "Monkey wise, there are the likes of De Brazza’s and colobuses, along with blue monkeys and some other rare simian species.",
            "Despite being one of the smallest national parks in Uganda, the swaying savannah grasses and riparian habitats of Lake Mburo certainly pack a punch.\n" +
                    "\n" +
                    "They come spotted with buffalo herds and zebras, crossed by prancing reedbucks, and stalked with hyenas.\n" +
                    "\n" +
                    "Today, much of the area is clad in young forestry, which springs up from the swamplands that dominate along the shores of the eponymous lake.\n" +
                    "\n" +
                    "These make for great game viewing during the dry season, when the animals congregate at the watering holes.\n" +
                    "\n" +
                    "What’s more, Lake Mburo National Park is one of the most accessible going, with easy access along the highway from Kampala, the capital.\n" +
                    "\n",
            "Pierce into the dense jungles and wetland forests of the great Kibale National Park and you won’t be disappointed! What awaits is one of the world’s most awesome arrays of wild chimpanzee packs, and you can see these majestic simians of Central Africa trawling through the undergrowth and commanding the canopies on game drives and safari excursions of all different types.\n" +
                    "\n" +
                    "There’s a kaleidoscope of other curious little monkeys to spot too, like the rare L’Hoest’s and the Ugandan red colobus.\n" +
                    "\n" +
                    "It’s also possible to wonder up at ancient fig trees, and see some more recent efforts to create sustainable coffee plantations in the area."

    };

//    available lodges
    String mLodges[] = {
            "Sipi falls lodge, Sipi Travellers lodge",
            "Lake bunyonyi eco resort, Byoona Amagara Island Retreat",
            "Budongo eco lodge, bamboo village",
            "Kidepo savana lodge",
            "Mahogany springs, Mihingo Lodge",
            "Victoria Forest Resort",
            "Sipi falls lodge, Sipi Travellers lodge",
            "Lake bunyonyi eco resort, Byoona Amagara Island Retreat",
            "Budongo eco lodge, bamboo village",
            "Kidepo savana lodge",
            "Mahogany springs, Mihingo Lodge",
            "Victoria Forest Resort",
            "Victoria Forest Resort"
    };

    String mDistance[] = {
            "345km", "356km", "367km",
            "590km", "432km", "95km",
            "345km", "356km", "367km",
            "590km", "432km", "95km", "234km"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mLocation, images, mLodges, mDescription, mPhoneNumbers, mDistance);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ViewTour.class);
//                prepare data to pass to next details activitity
                intent.putExtra("title", mTitle[position]);
                intent.putExtra("location", mLocation[position]);
                intent.putExtra("phone", mPhoneNumbers[position]);
                intent.putExtra("desc", mDescription[position]);
                intent.putExtra("image", images[position]);
                intent.putExtra("lodges", mLodges[position]);
                intent.putExtra("distance", mDistance[position]);
                startActivity(intent);
            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        String rPhone[];
        String rLocation[];
        String rLodge[];
        String rDistance[];
        int rImgs[];

        MyAdapter (Context c, String title[], String location[], int imgs[], String description[], String phone[],String lodge[], String distance[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rLocation = location;
            this.rDescription = description;
            this.rPhone = phone;
            this.rLodge = lodge;
            this.rDistance = distance;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myLocation = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myLocation.setText(rLocation[position]);

            return row;
        }
    }
}
