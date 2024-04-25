package pl.edu.pja.s23447.lab2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.concurrent.ThreadLocalRandom;

import pl.edu.pja.s23447.lab2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private final String RECIPE_1_NAME = "Lamb Pilaf";
    private final String RECIPE_1_INGREDIENTS = "\n" +
            "2 tbs Butter\n" +
            "1 chopped Onion\n" +
            "450g Lamb\n" +
            "2 cloves Garlic\n" +
            "600ml Vegetable Stock\n" +
            "2 cups Rice\n" +
            "Pinch Saffron\n" +
            "Garnish Parsley\n";
    private final String RECIPE_1_INSTRUCTION = "Place the raisins and prunes into a small bowl and pour over enough water to cover.\n" +
            "Add lemon juice and let soak for at least 1 hour.\n" +
            "Drain.\n" +
            "Roughly chop the prunes.\n" +
            "Meanwhile, heat the butter in a large pan, add the onion, and cook for 5 minutes.\n" +
            "Add cubed lamb, ground lamb, and crushed garlic cloves.\n" +
            "Fry for 5 minutes, stirring constantly until browned.\n" +
            "Pour 2/3 cup (150 milliliters) of stock into the pan.\n" +
            "Bring to a boil, then lower the heat, cover, and simmer for 1 hour, or until the lamb is tender.\n" +
            "Add the remaining stock and bring to a boil.\n" +
            "Add rinsed long-grain white rice and a large pinch of saffron.\n" +
            "Stir, then cover, and simmer for 15 minutes, or until the rice is tender.\n" +
            "Add the drained raisins, drained chopped prunes, and salt and pepper to taste.\n" +
            "Heat through for a few minutes, then turn out onto a warmed serving dish and garnish with sprigs of flat-leaf parsley.";

    private final String RECIPE_2_NAME = "Beetroot Soup";
    private final String RECIPE_2_INGREDIENTS = "3 Beetroot\n" +
            "4 tbs Olive Oil\n" +
            "1 Chicken Stock Cube\n" +
            "6 cups Water\n" +
            "3 Potatoes\n" +
            "1 can Cannellini Beans\n" +
            "Garnish Dill\n";
    private final String RECIPE_2_INSTRUCTION = "Chop the beetroot, add water and stock cube and cook for 15mins.\n" +
            "Add the other ingredients and boil until soft.\n" +
            "Finally add the beans and cook for 5mins.\n" +
            "Serve in the soup pot.";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        int min = 0;
        int max = 1;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        if (randomNum == 1) {
            binding.textHome.setText(RECIPE_2_NAME + "\n\n" + RECIPE_2_INGREDIENTS + "\n\n" + RECIPE_2_INSTRUCTION);
        }
        else {
            binding.textHome.setText(RECIPE_1_NAME + "\n\n" + RECIPE_1_INGREDIENTS + "\n\n" + RECIPE_1_INSTRUCTION);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}