package oc.necro.sonstige;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.Sonstige;

public class Territorien extends Sonstige {

    OptionsZaehlerGruppe oz;

	public Territorien() {
        titel = "Territorien";
        
        ogE.addElement(new OptionsGruppeEintrag("Chemoteich (2W6)"));
        ogE.addElement(new OptionsGruppeEintrag("Alte Ruinen (10)"));
        ogE.addElement(new OptionsGruppeEintrag("Schlacke (15)"));
        ogE.addElement(new OptionsGruppeEintrag("Mineralienader (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Siedlung (30)"));
        ogE.addElement(new OptionsGruppeEintrag("Erzmine (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Wartungstunnel (10)"));
        ogE.addElement(new OptionsGruppeEintrag("Ventilationsschächte (10)"));
        ogE.addElement(new OptionsGruppeEintrag("Höhlenfarm (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Wasserdestillator (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Bar (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Gildenkontakt (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Befreundeter Doc (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Werkstatt (W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Spielhölle (2W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Pilzhöhle (2W6 x 10)"));
        ogE.addElement(new OptionsGruppeEintrag("Archäotechlager (2W6 x 10)"));
        add(oz = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));


		complete();
	}

	@Override
	public void refreshen() {

		
	}

}
