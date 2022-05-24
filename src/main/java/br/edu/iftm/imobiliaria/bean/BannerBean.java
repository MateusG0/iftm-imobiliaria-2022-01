package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Banner;
import br.edu.iftm.imobiliaria.entity.Imagem;
import br.edu.iftm.imobiliaria.logic.BannerLogic;
import br.edu.iftm.imobiliaria.logic.ImagemLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class BannerBean extends CrudBean<Banner, BannerLogic> {

    @Inject
    private BannerLogic logic;

    public BannerBean() {
        super(Banner.class);
    }
    @Inject
    private ImagemLogic imagemLogic;

    @Override
    public BannerLogic getLogic() {
        return this.logic;
    }

    public List<Imagem> getImagens() {
        try {
            return imagemLogic.buscar(null);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

}
