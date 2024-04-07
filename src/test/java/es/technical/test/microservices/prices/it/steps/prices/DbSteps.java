package es.technical.test.microservices.prices.it.steps.prices;

import es.technical.test.microservices.prices.it.context.CucumberContext;
import org.springframework.beans.factory.annotation.Autowired;

public class DbSteps {

  @Autowired
  private CucumberContext context;
//  @Autowired
//  private Repository repository;
//
//  @Then("check existe en BBDD oferta con id {long}")
//  public void checkOfertaExistInDatabase(final long id){
//    Assertions.assertTrue(this.repository.findById(id).isPresent());
//  }
//
//  @Then("check existe en BBDD oferta con id generado")
//  public void checkOfertaExistInDatabase(){
//    Assertions.assertTrue(this.repository.findById(
//        Long.valueOf(context.generatedValues().get("id"))
//    ).isPresent());
//  }
//
//  @Then("check no existe en BBDD oferta con id {}")
//  public void checkOfertaNoExistInDatabase(final long id){
//    Assertions.assertTrue(this.repository.findById(id).isEmpty());
//  }
//
//  @Then("check modificado en BBDD oferta con id {long}, con categoria {long}, estado {word}, fechaPublicacion {string}, fechaExpiracion {string}, texto {string}, titulo {string}, imagen {word}, enlace {word}, localizaciones {word}, tags {word}")
//  public void checkUpdateOfertaExistInDatabase(final long id, final long categoriaId, final String estado, final String fechaPublicacion, final String fechaExpiracion, final String texto,
//      final String titulo, final String imagen, final String enlace, String localizaciones, String tags){
//    Optional<Oferta> ofertaOpt = this.repository.findById(id);
//    Assertions.assertTrue(ofertaOpt.isPresent());
//    Oferta oferta = ofertaOpt.get();
//    Assertions.assertEquals(id, oferta.getId());
//    Assertions.assertEquals(categoriaId, oferta.getCategoria().getId());
//    Assertions.assertEquals(estado, oferta.getEstado().toString());
//    Assertions.assertEquals(fechaPublicacion, oferta.getFechaPublicacion().toString());
//    Assertions.assertEquals(fechaExpiracion, oferta.getFechaExpiracion().toString());
//    Assertions.assertEquals(texto, oferta.getTexto());
//    Assertions.assertEquals(titulo, oferta.getTitulo());
//    if (!imagen.equals("null"))
//      Assertions.assertEquals(UUID.fromString(imagen), oferta.getImagen());
//    if (!enlace.equals("null"))
//      Assertions.assertEquals(UUID.fromString(enlace), oferta.getEnlace());
//    List<Tag> tagList = new LinkedList<>();
//    Arrays.stream(tags.split(",")).toList().forEach(idS -> tagRepository.findById(Long.valueOf(idS))
//        .ifPresent(tagList::add));
//    Assertions.assertEquals(tagList.get(0).getId(), oferta.getTags().get(0).getId());
//    Assertions.assertEquals(tagList.size(), oferta.getTags().size());
//    List<Localizacion> localizacionesList = new LinkedList<>();
//    Arrays.stream(localizaciones.split(",")).toList().forEach(idS -> localizacionRepository.findById(Long.valueOf(idS))
//        .ifPresent(localizacionesList::add));
//    Assertions.assertEquals(localizacionesList.size(), oferta.getLocalizaciones().size());
//    Assertions.assertEquals(localizacionesList.get(0).getId(), oferta.getLocalizaciones().get(0).getId());
//  }

}
