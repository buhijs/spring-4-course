package com.realdolmen.spring.repository;

// TODO: Configure this class as a Spring Bean and inject the Repository. Do not use @ComponentScan to search for it, nor @Bean
//public class ZooController {
//    private AnimalRepository animalRepository;
//
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public String index(Map<String, Object> model) {
//        return "redirect:" + fromMappingName("ZC#listAnimals").build();
//    }
//
//    @RequestMapping(value="animals", method = RequestMethod.GET)
//    public String listAnimals(Map<String, Object> model) {
//        model.put("animals", animalRepository.findAll());
//        return "zoo";
//    }
//
//    @RequestMapping(value="animal", method = RequestMethod.POST)
//    public String createAnimal(Animal animal) {
//        animalRepository.create(animal);
//        return "redirect:" + fromMappingName("ZC#listAnimals").build();
//    }
//
//    @RequestMapping(value="animal/{id}/remove", method = RequestMethod.GET)
//    public String removeAnimal(@PathVariable("id") int id) {
//        animalRepository.remove(id);
//        return "redirect:" + fromMappingName("ZC#listAnimals").build();
//    }
//}
