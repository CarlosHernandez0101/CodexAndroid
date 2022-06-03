package com.example.codexbettingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack

@Composable
fun TermsView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(CodexBlack)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(CodexBlack),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CodexNavigationBar()

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(horizontal = 15.dp)) {

                Text(
                    "Política de privacidad",
                    color = Color.White,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                )

                Text(
                    "Codex Betting únicamente utiliza sus datos personales para tener registro de sus usuarios. Su información no será compartida con ningún tercero.\n" +
                            "\n" +
                            "Datos personales tratados.\n" +
                            "\n" +
                            "Nombre de usuario\n" +
                            "\n" +
                            "Correo electrónico \n" +
                            "\n" +
                            "Hosting e infraestructura de backend\n" +
                            "\n" +
                            "Firesabase\n" +
                            "\n" +
                            "Codex Betting informa que el usuario tiene derecho a:\n" +
                            "\n" +
                            "Conocer qué datos personales se están recabando\n" +
                            "\n" +
                            "Cancelar el uso de datos personales\n" +
                            "\n" +
                            "Protección de datos personales\n" +
                            "\n" +
                            "Como medida de protección a sus datos personales el almacenamiento de los mismos es realizado teniendo en cuenta todas las medidas de seguridad informática para salvaguardar la información ",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 20.dp
                        )
                )

                Text(
                    "Términos y condiciones",
                    color = Color.White,
                    fontSize = 28.sp,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(bottom = 20.dp)
                )

                Text(
                    "Al utilizar los servicios de esta aplicación debes  de aceptar los términos y condiciones. En caso contrario, por favor, no utilices la aplicación.",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 20.dp
                        )
                )

                Text(
                    "Cuenta premium\n" +
                            "\n" +
                            "Al hacer el pago por la cuenta premium usted podrá acceder a todas las funcionalidades y/o servicios disponibles. Algunas funcionalidades y/o servicios necesitan acceso a internet.\n" +
                            "Las funcionalidades y/o servicios pueden cambiar sin previo aviso.",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 20.dp
                        )
                )

                Text(
                    "A través de la aplicación de Codex Betting el usuario tiene acceso a contenidos publicados en la nube.\n" +
                            "\n" +
                            "Pago por cuenta premium\n" +
                            "\n" +
                            "Debe hacer el pago de la cuenta premium por transferencia bancaria o vía PayPal.\n" +
                            "\n" +
                            "Después de pagar su suscripción usted será dado de alta en nuestro sistema durante las siguientes 24 horas. En caso de que demore más  tiempo póngase en contacto con servicio al cliente.\n",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 15.dp
                        )
                )


                Text(
                    "En caso de existir una falla en su pago podrá suspenderse su cuenta hasta que el pago sea exitoso.\n" +
                            "\n" +
                            "En caso de encontrar alguna irregularidad en el pago su cuenta puede ser eliminada sin previo aviso.\n" +
                            "\n" +
                            "Para cancelar su cuenta en el sistema debe de enviar correo a contacto.codex.betting@gmail.com\n" +
                            "\n" +
                            "Codex Betting se reserva el derecho a cambiar los precios y planes de pago.\n" +
                            "\n" +
                            "El uso del contenido es limitado a un solo individuo y puede cambiar sin previo aviso.",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 15.dp
                        )
                )

                Text(
                    "Comportamiento del usuario \n" +
                            "\n" +
                            "Para hacer uso de cualquier a de los productos debes de tener como mínimo 18 años o la edad que indique tu país para la mayoría de edad.\n" +
                            "\n" +
                            "El usuario debe de proporcionar datos fidedignos en su registro. Solo está permitido tener una cuenta por persona, queda prohibido compartir información de acceso con otras personas.\n" +
                            "\n" +
                            "El uso sin autorización del sistema puede resultar en reclamaciones o incluso en procesos penales.\n" +
                            "\n" +
                            "El usuario acepta no utilizar el sitio con fines distintos a los establecidos por Codex Betting. Así mismo, acepta no utilizar los productos para realizar alguna actividad ilícita que infrinja cualquier ley de su país.\n" +
                            "\n" +
                            "El usuario acepta no dañar ninguno de los servicios ofrecidos por Codex Betting, así como no manipular información, sistemas informáticos, o documentos afectando su confidencialidad, integridad y disponibilidad. \n" +
                            "\n" +
                            "El uso de la cuenta está limitada a una sola persona. En caso de detectar el uso de más de una persona la cuenta será eliminada permanentemente y no se hará ningún tipo de reembolso.\n" +
                            "\n" +
                            "Codex Betting podrá negar el acceso a registrarse o de eliminar cualquier cuenta que viole los términos y condiciones.\n" +
                            "\n" +
                            "Propiedad intelectual \n" +
                            "\n" +
                            "Todos los derechos reservados.\n" +
                            "\n" +
                            "Queda estrictamente prohibido todo tipo de reproducción, almacenamiento persistente o difusión de los contenidos de la aplicación sin el previo consentimiento de Codex Betting.\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "Responsabilidad\n" +
                            "\n" +
                            "El acceso a la aplicación no significa ninguna relación comercial entre Codex Betting y los usuarios.\n" +
                            "\n" +
                            "En Codex Betting realizamos el mayor esfuerzo por entregar productos de calidad, pero se debe de tomar en cuenta lo siguiente:\n" +
                            "\n" +
                            "No se ofrece ninguna garantía de exactitud de datos. Aceptas que puede haber inconsistencias, errores o inexactitudes en los productos ofrecidos.\n" +
                            "\n" +
                            "Codex Betting no se hace responsable si la aplicación o los servidores no se encuentran disponibles de forma temporal debido a problemas técnicos externos fuera del alcance de nuestro equipo de trabajo.\n" +
                            "\n" +
                            "El uso de los contenidos y productos son responsabilidad del usuario. Codex Betting no se hace responsable.\n" +
                            "De igual forma, el usuario deberá verificar que los servicios ofrecidos por Codex Betting se adaptan a sus necesidades.\n" +
                            "\n" +
                            "Las ganancias mostradas en los contenidos publicitarios son resultado de estadísticas previas y estimaciones, los cuáles pueden llegar a cambiar con el tiempo, por lo que no se garantiza un beneficio exacto.\n" +
                            "\n" +
                            "De igual forma, no se garantiza un beneficio ya que todo depende del uso correcto que realice el usuario con los productos, de los mercados disponibles o de las posibles limitaciones personales que pudieran tener los usuarios.\n" +
                            "\n" +
                            "Codex Betting no se hace responsable de ninguna pérdida ocasionada por los usuarios sin importar la causa de la misma, tampoco se hace responsable de pérdidas subsecuentes o daños resultantes con las pérdidas.\n" +
                            "\n" +
                            "Enlaces a sitios web de terceros \n" +
                            "\n" +
                            "La aplicación contiene enlaces a sitios web de terceros. Codex Betting no tiene control sobre ninguno de estos sitios, por lo que no se hace responsable por el uso que se le den a sus datos en dichos sitios. \n" +
                            "\n" +
                            "Leyes aplicables \n" +
                            "\n" +
                            "Las leyes aplicables están en base a las leyes de los Estados Unidos Mexicanos.\n",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 15.dp
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TermsViewPreview() {
    CodexBettingTheme {
        TermsView()
    }
}