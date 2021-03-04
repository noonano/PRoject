package app.dev.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class Category_Selection extends AppCompatActivity{
    LinearLayout btnFamily, btnLove, btnCareer, btnFinance, btnHealth;
    Random rand = new Random();
    TextView greeting;
    String text;

    String[] familyQuote = {
            "“The most important thing in the world is family and love.” –John Wooden",
            "“Nothing is better than going home to family and eating good food and relaxing.” –Irina Shayk",
            "“To us, family means putting your arms around each other and being there.” –Barbara Bush",
            "“In family life, love is the oil that eases friction, the cement that binds closer together, and the music that brings harmony.” –Friedrich Nietzsche",
            "“Other things may change us, but we start and end with the family.” –Anthony Brandt",
            "“Having somewhere to go is home. Having someone to love is family. And having both is a blessing.”",
            "“Being a family means you are a part of something very wonderful. It means you will love and be loved for the rest of your life.” –Lisa Weed",
            "Humor can help ease the tension of family when things get tough. If you need a light-hearted reminder of the funny side of family, look to the quotes below:",
            "“Happiness is having a large, loving, caring, close-knit family in another city.” –George Burns",
            "“The informality of family life is a blessed condition that allows us all to become our best while looking our worst.” –Marge Kennedy",
            "“Families are like fudge – mostly sweet with a few nuts.”",
            "“Being part of a family means smiling for photos.” –Harry Morgan",
            "“Family ties mean that no matter how much you might want to run from your family, you can’t.”",
            "“Family is not an important thing. It’s everything.” –Michael J. Fox",
            "“The memories we make with our family is everything.” –Candace Cameron Bure",
            "“Family is family.” –Linda Linney",
            "“The family is one of nature’s masterpieces.” –George Santayana",
            "“In time of test, family is best.” –Burmese Proverb",
            "“It’s all about the quality of life and finding a happy balance between work and friends and family.” –Philip Green",
            "“Family and friendships are two of the greatest facilitators of happiness.” –John C. Maxwell",
            "“Treat your family like friends and your friends like family.”",
            "“Family and friends are hidden treasures, seek them and enjoy their riches.” –Wanda Hope Carter",
            "“Stick to the basics, hold on to your family and friends – they will never go out of fashion.” –Niki Taylor",
            "“My family is my life, and everything else comes second as far as what’s important to me.” –Michael Imperioli",
            "“A happy family is but an earlier heaven.” –George Bernard Shaw",
            "“The family is the test of freedom; because the family is the only thing that the free man makes for himself and by himself.” –Gilbert K. Chesterton",
            "“Think of your family today and every day thereafter, don’t let the busy world of today keep you from showing how much you love and appreciate your family.” –Josiah"
    };

    String[] loveQuote = {
            "“Love takes off masks that we fear we cannot live without and know we cannot live within.” — James Baldwin",
            "“Love yourself first and everything else falls into line. You really have to love yourself to get anything done in this world.” —  Lucille Ball",
            "“Once the realization is accepted that even between the closest human beings infinite distances continue, a wonderful living side by side can grow, if they succeed in loving the distance between them which makes it possible for each to see the other whole against the sky.” — Rainer Maria Rilke",
            "“The most important thing in life is to learn how to give out love, and to let it come in.” — Morrie Schwartz",
            "“Love will find a way through paths where wolves fear to prey.” — Lord Byron",
            "“If I know what love is, it is because of you.” — Herman Hesse",
            "“I love you not because of who you are, but because of who I am when I am with you.” — Roy Croft",
            "“Love is a friendship set to music.” —  Joseph Campbell",
            "“We are shaped and fashioned by what we love.” — Johann Wolfgang von Goethe",
            "“When we are in love we seem to ourselves quite different from what we were before.” — Blaise Pascal",
            "“Love in its essence is spiritual fire.” — Seneca",
            "“The way to love anything is to realize that it may be lost.” — Gilbert K. Chesterton",
            "“It takes courage to love, but pain through love is the purifying fire which those who love generously know. We all know people who are so much afraid of pain that they shut themselves up like clams in a shell and, giving out nothing, receive nothing and therefore shrink until life is a mere living death.” — Eleanor Roosevelt",
            "“Don't brood. Get on with living and loving. You don't have forever.” — Leo Buscaglia",
            "“Love recognizes no barriers. It jumps hurdles, leaps fences, penetrates walls to arrive at its destination full of hope.” — Maya Angelou",
            "“There is only one happiness in this life, to love and be loved.”— George Sand",
            "“Your task is not to seek for love, but merely to seek and find all the barriers within yourself that you have built against it.” — Rumi",
            "“Love is of all passions the strongest, for it attacks simultaneously the head, the heart and the senses.” — Lao Tzu",
            "“You know it's love when all you want is that person to be happy, even if you're not part of their happiness.” — Julia Roberts",
            "“At the touch of love everyone becomes a poet.” — Plato",
            "“If I had a flower for every time I thought of you… I could walk through my garden forever.” — Alfred Tennyson",
            "“When you arise in the morning, think of what a precious privilege it is to be alive – to breathe, to think, to enjoy, to love.” — Marcus Aurelius"
    };

    String[] financeQuote = {
            "“The speed of your success is limited only by your dedication and what you’re willing to sacrifice” – Nathan W. Morris",
            "“It’s pointless to set goals if you are not going to try to hit them.” – Don Connelly",
            "“Financial fitness is not a pipe dream or a state of mind. It’s a reality if you are willing to pursue it and embrace it.” – Will Robinson",
            "“It’s quite easy to spend $20,000 getting two people to Europe for two weeks. The same $20,000 invested at a reasonable rate of return over several years makes the opportunity cost of going to Europe prohibitive.” – Don Connelly",
            "“Rich people act in spite of fear. Poor people let fear stop them.” – The Power of Thinking Like the Rich – The Message of Rich Dad Poor Dad.",
            "“You can’t always visualize the reward, but you can believe in the sacrifice if the vision is strong enough.” – Don Connelly",
            "“At least eighty percent of millionaires are self-made. That is, they started with nothing but ambition and energy, the same way most of us start.” – Brian Tracy",
            "“Financial security and independence are like a three-legged stool resting on savings, insurance and investments.” – Brian Tracy",
            "“What separates the winners from the losers is how a person reacts to each new twist of fate.” – Donald Trump",
            "“The difference between succeeding and failing is consistency.” – Don Connelly",
            "“I feel that luck is preparation meeting opportunity.” – Oprah Winfrey",
            "“People who are enthusiastic make more money than people who are not enthusiastic. Choose to be enthusiastic.” – Don Connelly",
            "“Predicting the future with any degree of Certainty is impossible. The key is to react accordingly to any situation as it arises.” – Don Connelly",
            "“Buy at the point of maximum pessimism; sell at the point of maximum optimism.” – Sir John Templeton",
            "“Whether socks or stocks, I like buying quality merchandise when it is marked down.” – Warren Buffett",
            "“Having information on investing is one thing. Knowing what to do with it is something else entirely.” – Don Connelly",
            "“More people should learn to tell their dollars where to go instead of asking them where they went.” – Roger Babson",
            "“The day I was born, the Dow Jones Industrial Average closed at 188.58. The day I graduated from high school, the Dow closed at 716.49. The day I turned sixty five, the Dow closed at 10,522.59. Here we are over 17,000. The long term trend is obvious.” – Don Connelly",
            "“When someone pays you a commission for a purchase, it’s not to purchase that product; it’s to know which product to purchase.” – Don Connelly",
            "“Doctors know needles hurt. They give shots nonetheless. Why? Because they know that little bit of discomfort up front leads to miracles down the road.” – Don Connelly"
    };

    String[] careerQuote = {
            "The truth is that our finest moments are most likely to occur when we are feeling deeply uncomfortable, unhappy, or unfulfilled. For it is only in such moments, propelled by our discomfort, that we are likely to step out of our ruts and start searching for different ways or truer answers. -Alice Walker",
            "If you don’t feel it, flee from it. Go where you are celebrated, not merely tolerated.-M. Scott Peck",
            "Find out what you like doing best, and get someone to pay you for doing it. -Paul F. Davis",
            "If opportunity doesn’t knock, build a door. -Katharine Whitehorn",
            "Wanting to be someone else is a waste of the person you are. -Milton Berle",
            "The future depends on what you do today. -Kurt Cobain",
            "You only live once, but if you do it right, once is enough. -Mahatma Gandhi",
            "I am not a product of my circumstances. I am a product of my decisions. -Mae West",
            "Opportunities don't happen, you create them. -Stephen Covey",
            "Start by doing what is necessary, then what is possible, and suddenly you are doing the impossible. -Chris Grosser",
            "Style is knowing who you are, what you want to say, and not giving a damn. -Francis of Assisi",
            "The future belongs to those who believe in the beauty of their dreams. -Gore Vidal",
            "The only way to do great work is to love what you do. If you haven't found it yet, keep looking. Don't settle. -Eleanor Roosevelt",
            "It is never too late to be what you might have been. -Steve Jobs",
            "Everything I’ve ever let go of has claw marks on it. -George Eliot"
    };

    String[] healthQuote = {
            "“Health is a state of complete harmony of the body, mind and spirit. When one is free from physical disabilities and mental distractions, the gates of the soul open.” – B.K.S. Iyengar",
            "“To ensure good health: eat lightly, breathe deeply, live moderately, cultivate cheerfulness, and maintain an interest in life.” -William Londen",
            "“Physical fitness is the first requisite of happiness.” – Joseph Pilates",
            "“The human body has been designed to resist an infinite number of changes and attacks brought about by its environment. The secret of good health lies in successful adjustment to changing stresses on the body.” – Harry J. Johnson",
            "“To keep the body in good health is a duty…otherwise we shall not be able to keep the mind strong and clear.” – Buddha",
            "“Good health is not something we can buy. However, it can be an extremely valuable savings account.”-Anne Wilson Schaef",
            "“You can’t control what goes on outside, but you CAN control what goes on inside.” – Unknown",
            "“The cheerful mind perseveres, and the strong mind hews its way through a thousand difficulties.” – Swami Vivekananda",
            "“It is health that is the real wealth, and not pieces of gold and silver.” – Mahatma Gandhi",
            "“Keeping your body healthy is an expression of gratitude to the whole cosmos- the trees, the clouds, everything.” – Thich Nhat Hanh",
            "“Divide each difficulty into as many parts as is feasible and necessary to resolve it, and watch the whole transform.” – Rene Descartes",
            "“Every negative belief weakens the partnership between mind and body.” – Deepak Chopra",
            "“Health is a state of complete mental, social and physical well-being, not merely the absence of disease or infirmity.” – World Health Organization, 1948",
            "“The doctor of the future will give no medicine, but will instruct his patients in care of the human frame, in diet, and in the cause and prevention of disease.” – Thomas Edison",
            "“I have chosen to be happy because it is good for my health.” – Voltaire",
            "“A sad soul can be just as lethal as a germ.” – John Steinbeck",
            "“If you know the art of deep breathing, you have the strength, wisdom and courage of ten tigers.” – Chinese adage",
            "“Remain calm, because peace equals power.”- Joyce Meyer",
            "“Healthy citizens are the greatest asset any country can have.” – Winston Churchill",
            "“A good laugh and a long sleep are the best cures in the doctor’s book.” – Irish proverb",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else {
            setTheme(R.style.LightTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__selection);

        hideFragment();

        Intent intent = getIntent();
        text = intent.getStringExtra("NAME");

        variableInitializations();

        greeting.setText("Hi " + text + "! How are you today? Need some inspiring or relatable quotes for today? \nPlease pick a category!");

        buttons();

    }

    public void variableInitializations(){
        greeting = (TextView) findViewById(R.id.greeting);
        btnFamily = (LinearLayout) findViewById(R.id.btnFamily);
        btnLove = (LinearLayout) findViewById(R.id.btnLove);
        btnFinance = (LinearLayout) findViewById(R.id.btnFinance);
        btnCareer = (LinearLayout) findViewById(R.id.btnCareer);
        btnHealth = (LinearLayout) findViewById(R.id.btnHealth);
    }

    public void buttons() {
        btnFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randQuote = rand.nextInt(familyQuote.length);
                String quote = familyQuote[randQuote];
                nextActivity("Family", quote, "family");
            }
        });

        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randQuote = rand.nextInt(loveQuote.length);
                String quote = loveQuote[randQuote];
                nextActivity("Love", quote, "love");
            }
        });

        btnFinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randQuote = rand.nextInt(financeQuote.length);
                String quote = financeQuote[randQuote];
                nextActivity("Finance", quote, "finance");
            }
        });

        btnCareer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randQuote = rand.nextInt(careerQuote.length);
                String quote = careerQuote[randQuote];
                nextActivity("Career", quote, "career");
            }
        });

        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randQuote = rand.nextInt(healthQuote.length);
                String quote = healthQuote[randQuote];
                nextActivity("Health", quote, "health");
            }
        });

    }

    public void hideFragment(){
        FragmentManager manager = this.getSupportFragmentManager();
        manager.beginTransaction()
                .hide(manager.findFragmentById(R.id.menuFragment))
                .addToBackStack(null)
                .commit();
    }

    void nextActivity(String categoryTitle, String quote, String theme) {
        Intent intent = new Intent(this, Category_of_Choice.class);

        intent.putExtra("category",categoryTitle);
        intent.putExtra("quote",quote);
        intent.putExtra("theme", theme);

        startActivity(intent);
    }

    public void viewMenu(View view) {
        FragmentManager manager = this.getSupportFragmentManager();
        manager.beginTransaction()
                .show(manager.findFragmentById(R.id.menuFragment))
                .addToBackStack(null)
                .commit();
    }
}