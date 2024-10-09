package Serdaigle.MIAGIE.exception;

/**
 * Exception levée lorsque l'élève demandé n'est pas trouvé dans le système.
 * Cette exception est une sous-classe de {@link RuntimeException} et est utilisée pour
 * signaler une erreur lorsque l'ID ou les informations d'un élève ne peuvent pas être trouvés.
 *
 * @author Serdaigle
 * @version 1.0
 * @since 2024-10-08
 */
public class EleveNotFoundException extends RuntimeException {

    /**
     * Constructeur de l'exception qui accepte un message détaillant la cause de l'erreur.
     *
     * @param message Le message décrivant la raison pour laquelle l'élève n'a pas été trouvé.
     */
    public EleveNotFoundException(String message) {
        super(message);
    }
}
