import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository; // Assumindo que você tem um repositório JPA para atividades

    @GetMapping("/activities")
    public String showActivities(Model model) {
        List<Activity> activities = activityRepository.findAll();
        model.addAttribute("activities", activities);
        return "activities";
    }

    @PostMapping("/addActivity")
    public String addActivity(@RequestParam String activityName, @RequestParam String activityDate) {
        Activity activity = new Activity();
        activity.setActivityName(activityName);
        activity.setActivityDate(activityDate);
        activityRepository.save(activity);
        return "redirect:/activities";
    }

    // Outros métodos para editar, excluir etc., conforme necessário
}
