package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class SMServitoren extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public SMServitoren() {
		grundkosten = -5;
        setEintragsCNT(0.0);
        
        BuildaHQ.addToInformationVector("SMServitoren", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Servitor", "Servitoren", 1, 5, 15);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMServitoren.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 30));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		complete();
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("SMServitoren", -1);
    }

	@Override
	public void refreshen() {
        o1.setMaxAnzahl((squad.getModelle() > 1 ? 2 : 1));
        
		int selectedSquads = BuildaHQ.getCountFromInformationVector("SMServitoren");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("SMTechmarineOderMeister");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Anzahl > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

}
