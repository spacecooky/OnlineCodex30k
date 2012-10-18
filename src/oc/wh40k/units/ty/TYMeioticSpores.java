package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TYMeioticSpores extends Eintrag {

    AnzahlPanel squad;
        
    public TYMeioticSpores() {
        name = "Meiotic Spore";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Meiotic Spore", "Meiotic Spores", 1, 3, 35);
		add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/TYMeioticSpore.gif"));
        

        complete();

    }

    @Override
	public void refreshen() {
	}

}
